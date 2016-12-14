package com.algaworks.brewer.storage.local;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.algaworks.brewer.storage.FotoStorage;

public class FotoStorageLocal implements FotoStorage {
	
	private Path local;
	private Path localTemporario;
	
	public FotoStorageLocal () {
		this.local = FileSystems.getDefault().getPath(System.getenv("HOME"), ".cervejariafotos");
		criarPastas();
	}

	@Override
	public String salvartemporariamente(MultipartFile[] files) {
		
		String novoNome = null;
		if (files != null && files.length > 0) {
			MultipartFile arquivo = files[0];
			novoNome = renomearArquivo(arquivo.getOriginalFilename());
			try {
				arquivo.transferTo(new File(this.localTemporario.toAbsolutePath().toString() + FileSystems.getDefault().getSeparator() + novoNome));
			} catch (IOException e) {
				throw new RuntimeException("Erro salvando a foto na pasta temporária", e);
			}
		}
		
		return novoNome;
		
	}
	
	@Override
	public byte[] recuperarFotoTemporaria(String nome) {
		
		try {
			return Files.readAllBytes(this.localTemporario.resolve(nome));
		} catch (IOException e) {
			throw new RuntimeException("error lendo foto temporaria", e);
		}
	}
	
	private String renomearArquivo(String nomeOriginal) {
		String novoNome = UUID.randomUUID().toString() + "_" + nomeOriginal;
		
		return novoNome;
		
	}
	
	private void criarPastas() {

		try {
			Files.createDirectories(local);
			this.localTemporario = FileSystems.getDefault().getPath(this.local.toString(), "temp");
			Files.createDirectories(this.localTemporario);
		} catch (IOException e) {
			throw new RuntimeException("Falha ao criar pasta para salvar foto", e);
		}
	}

	

	
	
	
	

}
