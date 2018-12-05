package com.certificate.validate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

public class CertValidation {
	public static void main(String[] args) {
		try {
			checkSelfSignedCert();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static boolean checkSelfSignedCert() throws CertificateException, InvalidKeyException,
	NoSuchAlgorithmException, NoSuchProviderException, SignatureException, FileNotFoundException {
		String pathtoCertificate = "ca.cer";
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		Certificate certificate = certificateFactory.generateCertificate(new FileInputStream(pathtoCertificate));
		System.out.println(certificate);
		PublicKey publicKey = certificate.getPublicKey();
		certificate.verify(publicKey);
		return true;
	}
}
