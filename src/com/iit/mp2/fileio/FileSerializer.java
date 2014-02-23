package com.iit.mp2.fileio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.iit.mp2.exception.FileParsingException;

/*
 * This file Serializes the data from data files.
 * User need to provide file path where the serialized file should be saved. 
 */

public class FileSerializer {

	private TotalList totalList;
	private FileOutputStream fileOutputStream;
	ObjectOutputStream objectOutputStream;
	
	public FileSerializer(TotalList totalList) {
		this.totalList = totalList;
	}

	public void saveTotalListTo(String serializationFilePath) throws FileParsingException {

		try {
			this.fileOutputStream = new FileOutputStream(serializationFilePath);
			this.objectOutputStream = new ObjectOutputStream(fileOutputStream);
			this.objectOutputStream.writeObject(this.totalList);
			this.objectOutputStream.close();
			System.out.println("Total Object Serialization done!\n");
		} catch (IOException e) {
			//throw new FileParsingException("some fileIOException in FileSerializer Class, saveTotalListTo method\n");
			System.out.println("some fileIOException in FileSerializer Class, saveTotalListTo method\n"+e.getMessage());
		}
	}

}
