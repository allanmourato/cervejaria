package com.algaworks.brewer.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {
	
	public String salvartemporariamente (MultipartFile[] files);

	public byte[] recuperarFotoTemporaria(String nome);
		

}
