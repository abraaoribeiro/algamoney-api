package com.example.algamoney.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("algamoney")
public class AlgamoneyApiProperty {

	private String originPermitida = "*";

	private final Seguranca serguranca = new Seguranca();

	private final Mail mail = new Mail();

	private final S3 s3 = new S3();

	public S3 getS3() {
		return s3;
	}

	public Seguranca getSeguranca() {
		return serguranca;

	}

	public Mail getMail() {
		return mail;
	}

	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}

	public Seguranca getSerguranca() {
		return serguranca;
	}

	public static class Seguranca {
		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}

	}

	public static class S3 {
		private String accessKeyId;
		private String secretAccesKey;
		private String bucket = "lm-arquivos";

		public String getBucket() {
			return bucket;
		}
		
		public void setBucket(String bucket) {
			this.bucket = bucket;
		}
		
		public String getAccessKeyId() {
			return accessKeyId;
		}

		public void setAccessKeyId(String accessKeyId) {
			this.accessKeyId = accessKeyId;
		}

		public String getSecretAccesKey() {
			return secretAccesKey;
		}

		public void setSecretAccesKey(String secretAccesKey) {
			this.secretAccesKey = secretAccesKey;
		}

	}

	public static class Mail {
		private String host;
		private Integer port;
		private String username;
		private String password;

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public Integer getPort() {
			return port;
		}

		public void setPort(Integer port) {
			this.port = port;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}
}
