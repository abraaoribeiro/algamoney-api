package com.example.algamoney.api.storage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.ObjectTagging;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.SetObjectTaggingRequest;
import com.example.algamoney.api.config.property.AlgamoneyApiProperty;

@Component
public class S3 {

	@Autowired
	private AlgamoneyApiProperty property;

	@Autowired
	private AmazonS3 amazonS3;

	private static Logger logger = LoggerFactory.getLogger(S3.class);

	public String salvarTemporariamente(MultipartFile file) {
		AccessControlList acl = new AccessControlList();
		acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);

		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentType(file.getContentType());
		metadata.setContentLength(file.getSize());

		String nomeUnico = gerarNomeUnico(file.getName());

		try {
			PutObjectRequest objectRequest = new PutObjectRequest(property.getS3().getBucket(), nomeUnico,
					file.getInputStream(), metadata).withAccessControlList(acl);

			objectRequest.setTagging(new ObjectTagging(Arrays.asList(new Tag("expirar", "true"))));

			amazonS3.putObject(objectRequest);

			if (logger.isDebugEnabled()) {
				logger.debug("Arquivo {} enviado com sucesso para S3", file.getName());
			}

		} catch (IOException e) {
			throw new RuntimeException("Problema ao enviar arquivo ao s3", e);
		}

		return nomeUnico;

	}

	public void salvar(String objeto) {
		SetObjectTaggingRequest setObjectTaggingRequest = new SetObjectTaggingRequest(property.getS3().getBucket(),
				objeto, new ObjectTagging(Collections.emptyList()));

		amazonS3.setObjectTagging(setObjectTaggingRequest);

	}

	public void remover(String objeto) {
		DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(
				property.getS3().getBucket(), objeto);
		
		amazonS3.deleteObject(deleteObjectRequest);
	}

	public void substituir(String objetoAntigo, String objetoNovo) {
		if(StringUtils.hasText(objetoAntigo)) {
			remover(objetoAntigo);
		}
		
		salvar(objetoNovo);
		
	}
	
	public String configurarUrl(String objeto) {
		return "\\\\" + property.getS3().getBucket() + ".s3.amazonaws.com/" + objeto;
	}

	private String gerarNomeUnico(String name) {
		return UUID.randomUUID().toString() + "_" + name;
	}

	

}
