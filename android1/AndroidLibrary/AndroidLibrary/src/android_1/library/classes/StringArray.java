/*
 * Copyright (C) 2013 xDevStudio
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.   
 *  
 * */

package android_1.library.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import android.content.res.Resources;

/**
 * Class for working with dynamic array of strings. With the ability to 
 * import data from the application's resources and work with streams.
 * 
 * @author Mikhail Malakhov
 * 
 * */
public class StringArray extends ArrayList<String> {

	/** Private constant from a super class */
	private static final long serialVersionUID = 1L;
	
	/** Constant that describe value of error code for loading operations */
	public static final int LOAD_ERROR_CODE = -1;
		
	/*--------------------------------------------------------------------*/
	/* Several constructors 
	/*--------------------------------------------------------------------*/
	
	/** 
	 * Constructs a new {@code StringArray} instance with zero initial 
	 * capacity.
	 * */		
	public StringArray() { super(); }
	
	/**
	 * Constructs a new instance of {@code StringArray} with the specified
	 * initial capacity.
	 * 
	 * @param capacity the initial capacity of this {@code ArrayList}
	 *  
	 * */
	public StringArray(int capacity) { super(capacity); }
		
	/** 
	 * Constructs a new {@code StringArray} instance with zero initial 
	 * capacity and loading data to this object from application resources.
	 * 
	 *  @param appRes application resources
	 *  @param resID id of resource that contains array of strings
	 *  
	 * */			
	public StringArray(Resources appRes, int resID) {
		super();
		this.load(appRes, resID, false);
	}	
	
	/** 
	 * Constructs a new {@code StringArray} instance with zero initial 
	 * capacity and load data from InputStream object.
	 * 
	 *  @param iStream input stream that contains a data for import
	 *  
	 * */	
	public StringArray(InputStream iStream) {
		super();
		this.load(iStream, false);
	}
	
	
	/*--------------------------------------------------------------------*/
	/* Add data to this object 
	/*--------------------------------------------------------------------*/
	
	/**
	 * Adds the strings in the specified array to this {@code ArrayList}.
	 * 
	 * 	@param array the array of string that will added to this object
	 * 
	 * */
	public void addAll(String[] array) {		
		for (String str: array) this.add(str);		
	}
	
	
	/*--------------------------------------------------------------------*/
	/* Convert object data to other formats
	/*--------------------------------------------------------------------*/
	
	/**
	 * Converts all data of this object to string.
	 * 
	 * 	@param seprtStr string that using as separator between elements of this
	 * 		object
	 * 	
	 * 	@return All data of this object as string.
	 * 
	 * */
	public String toString(String seprtStr) {
		
		/* Create a StringBuilder Object */
		StringBuilder SBuilder = new StringBuilder();
		
		/* Filling a StringBuilder Object */
		for (int i = 0; i < this.size(); i++) 
			SBuilder.append(this.get(i) + seprtStr);
		
		/* Return a value as String */
		return SBuilder.toString();	
				
	}
	
	/**
	 * Converts all data of this object to array of strings. 
	 * 	
	 * 	@return All data of this object as array of strings.
	 * 
	 * */
	public String[] toArray() {
		
		/* Getting size of collection */
		int size = this.size();
		
		/* Creating array of strings */
		String[] array = new String[size];
				
		/* Filling array of strings with objects' data */
		for (int i = 0; i < size; i++ ) array[i] = this.get(i);
			
		/* Return a value */
		return array;
		
	}
	
	
	/*--------------------------------------------------------------------*/
	/* Load data from other objects
	/*--------------------------------------------------------------------*/

	/**
	 * Loads data to this object from application resources.
	 * 
	 * 	@param appRes application resources
	 *  @param resID id of resource that contains array of strings
	 *  @param clearBefore if it is equal true, all data of this object 
	 *  	will be cleared before loading
	 *  
	 *  @return Number of added elements.
	 *  
	 *  @throws Resources.NotFoundException
	 * 
	 * */	
	public int loadWithThrow(Resources appRes, int resID, 
			boolean clearBefore) throws Resources.NotFoundException {
		
		/* Clear data before loading, if needed */
		if (clearBefore) this.clear();
		
		/* Creating array of strings */
		String[] array = null;
		
		/* Get array of strings from application resource */			
		array = appRes.getStringArray(resID);						
		
		/* Adding array of strings to this object */		
		this.addAll(array);
						
		/* Return an number of added elements */
		return array.length;		
		
	}
	
	/**
	 * Loads data to this object from application resources.
	 * 
	 * 	@param appRes application resources
	 *  @param resID id of resource that contains array of strings
	 *  @param clearBefore if it is equal true, all data of this object 
	 *  	will be cleared before loading
	 *  
	 *  @return Number of added elements or -1, if an error occurs.
	 * 
	 * */
	public int load(Resources appRes, int resID, boolean clearBefore) {						
		try {
			return this.loadWithThrow(appRes, resID, clearBefore);
		} catch (Resources.NotFoundException e) {
			return LOAD_ERROR_CODE;
		}
	}
	
	/**
	 * Loads data to this object from BufferedReader.
	 * 
	 * 	@param bReader The BufferedReader object that contains data
	 *  @param clearBefore if it is equal true, all data of this object 
	 *  	will be cleared before loading
	 *  
	 *  @return Number of added elements.
	 *  
	 *  @throws IOException
	 * 
	 * */	
	public int loadWithThrow(BufferedReader bReader, boolean clearBefore) 
			throws IOException {
		
		/* Clear data before loading, if needed */
		if (clearBefore) this.clear();
		
		/* Getting a number of elements into this object */
		int size = this.size();
		
		/* Creating string that will use as buffer */
		String bufStr = null;			
		
		/* Reading all lines from BufferedReader */
		while ((bufStr = bReader.readLine()) != null) 
			this.add(bufStr);		
		
		/* Close the BufferedReader */
		bReader.close();		
		
		/* Return number of added elements */
		return this.size() - size;		
		
	}
		
	/**
	 * Loads data to this object from BufferedReader.
	 * 
	 * 	@param bReader The BufferedReader object that contains data
	 *  @param clearBefore if it is equal true, all data of this object 
	 *  	will be cleared before loading
	 *  
	 *  @return Number of added elements or -1, if an error occurs.  
	 * 
	 * */
	public int load(BufferedReader bReader, boolean clearBefore) {		
		try {
			return this.loadWithThrow(bReader, clearBefore);
		} catch (IOException e1) {
			return LOAD_ERROR_CODE;
		}		
	}	
		
	/**
	 * Loads data to this object from InputStream.
	 * 
	 * 	@param iStream input stream that contains a data for import
	 *  @param clearBefore if it is equal true, all data of this object 
	 *  	will be cleared before loading
	 *  
	 *  @return Number of added elements.
	 * 
	 * 	@throws IOException 
	 * 
	 * */	
	public int loadWithThrow(InputStream iStream, boolean clearBefore) 
			throws IOException {
				
		/* Creating a BufferedReader object */
		BufferedReader bReader = new 
				BufferedReader(new InputStreamReader(iStream));
		
		/* Loading data from BufferedReader object and return value */
		return this.loadWithThrow(bReader, clearBefore);		
		
	}
	
	/**
	 * Loads data to this object from InputStream.
	 * 
	 * 	@param iStream input stream that contains a data for import
	 *  @param clearBefore if it is equal true, all data of this object 
	 *  	will be cleared before loading
	 *  
	 *  @return Number of added elements or -1, if an error occurs. 
	 * 
	 * */
	public int load(InputStream iStream, boolean clearBefore) {		
		try {
			return this.loadWithThrow(iStream, clearBefore);
		} catch (IOException e) {
			return LOAD_ERROR_CODE;
		}			
	}
	
	
	/*--------------------------------------------------------------------*/
	/* Save data to other object
	/*--------------------------------------------------------------------*/
	
	/**
	 * Saves data of this object to BufferedWriter.
	 * 
	 * 	@param bWriter the BufferedWriter object for writing a data
	 * 
	 * 	@throws IOException 
	 * 
	 * */
	public void saveWithThrow(BufferedWriter bWriter) throws IOException {
					
		/* Filling a BufferedWriter with object's data */
		for (int i = 0; i < this.size(); i++) {
			
			/* Write element */
			bWriter.write(this.get(i));			
			/* Write new line symbol */
			bWriter.newLine();
			
		}
		
		/* Close a BufferedWriter */
		bWriter.flush();
		bWriter.close();
		
	}
	
	/**
	 * Saves data of this object to BufferedWriter.
	 * 
	 * 	@param bWriter the BufferedWriter object for writing a data
	 * 
	 * 	@return False, if an error occurs.
	 * 
	 * */
	public boolean save(BufferedWriter bWriter) {		
		try {
			this.saveWithThrow(bWriter);
			return true;
		} catch (IOException e) {
			return false;
		}					
	}
	
	/**
	 * Saves data of this object to output stream.
	 * 
	 * 	@param oStream the OutputStream object for writing a data
	 * 
	 * 	@throws IOException 
	 * 
	 * */
	public void saveWithThrow(OutputStream oStream) throws IOException {
					
		/* Create BufferedWriter object */
		BufferedWriter bWriter = new 
				BufferedWriter(new OutputStreamWriter(oStream));
		
		/* Save data to BufferedWriter object */
		this.saveWithThrow(bWriter);		
		
	}	
	
	/**
	 * Saves data of this object to BufferedWriter.
	 * 
	 * 	@param bWriter the BufferedWriter object for writing a data
	 * 
	 * 	@return False, if an error occurs.
	 * 
	 * */
	public boolean save(OutputStream oStream) {		
		try {
			this.saveWithThrow(oStream);
			return true;
		} catch (IOException e) {		
			return false;
		}
	}

}
