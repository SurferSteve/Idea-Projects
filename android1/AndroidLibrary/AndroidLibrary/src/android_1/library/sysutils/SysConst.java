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

package android_1.library.sysutils;

/** 
 * Class for store constants that using in others classes. 
 * 
 * @author Mikhail Malakhov
 * 
 * */
public final class SysConst {	
	
	/*--------------------------------------------------------------------*/
	/* Constants for describe index value into a List (or array)
	/*--------------------------------------------------------------------*/	
	
	/** Value of index for the first element into a List. */
	public static final int INDEX_FIRST = 0;
	
	/** Value of index if a List is empty. */
	public static final int INDEX_EMPTY = -1;
	
	
	/*--------------------------------------------------------------------*/
	/* Constants for describe I/O codes of result
	/*--------------------------------------------------------------------*/

	/** I/O operation was successfully. */
	public static final int IOEX_SUCCESSFULLY = 0;
	
	/** FileNotFound error during I/O operation. */
	public static final int IOEX_FILENOTFOUND = 1;
	
	/** Unexpected error during I/O operation. */
	public static final int IOEX_UNEXPECTED = 2;	
	
	/** Error during I/O operation because a storage not available. */
	public static final int IOEX_STORAGE_NOT_AVAILABLE = 3;
	
	/** Error during I/O operation because a fine name is wrong. */
	public static final int IOEX_WRONGFILENAME = 4;
	
	
	/*--------------------------------------------------------------------*/
	/* Constants for describe connection result codes
	/*--------------------------------------------------------------------*/	
	
	/** Connection results Constants */
	public static final int CON_SUCCESSFULLY = 0;
	public static final int CON_NOT_FOUND = 1;
	public static final int CON_UNEXPECTED = 2;
	
	
	/*--------------------------------------------------------------------*/
	/* Several string constant
	/*--------------------------------------------------------------------*/	
		
	/** Empty string. */
	public static final String STR_EMPTY = "";
	
	/** Blank symbol. */
	public static final String STR_BLANK = " ";
	
	/** Comma symbol. */
	public static final String STR_SEPRT = ",";
	
	public static final String STR_EQUAL = "=";
	public static final String STR_NODAT = "nd";
	public static final String STR_NEWLN = "\n";
		
	public static final String STR_WEB_REQUEST_START = "?";
	public static final String STR_WEB_REQUEST_SEPRT = "&";
	public static final String STR_WEB_REQUEST_BLANK = "%20";
	public static final String STR_WEB_REQUEST_UNICODE = "%";
	public static final String STR_WEB_REQUEST_EQUAL = SysConst.STR_EQUAL;
		
}
