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

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;

/**
 * Class for working with a clip board service.
 * 
 * @author Mikhail Malakhov
 * 
 * */
public class Clipboard {
	

	/*--------------------------------------------------------------------*/
	/* Get clip board manager
	/*--------------------------------------------------------------------*/	
	
	/**
	 * Gets a link to the system clip board manager.
	 * 
	 *  @param context current application context
	 *  
	 * */
	public static Object getClipboardManager(Context context) {		
		return context.getSystemService(Context.CLIPBOARD_SERVICE);					
	}	
	
	
	/*--------------------------------------------------------------------*/
	/* Put data to the clip board
	/*--------------------------------------------------------------------*/	
	
	/** 
	 * Puts data to the clip board.
	 * 
	 * 	@param context current application context
	 * 	@param data a data for put to the clip board
	 * 
	 * */
	public static void put(Context context, String data) {			
	
		/* Checking a version of SDK and put data to the clip board */
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			Clipboard.put_API11(context, data);
		}			
		else {			
			Clipboard.put_API10(context, data);
		}
		
	}
	
	/** 
	 * Puts data to a clip board.
	 * 
	 * 	@param context current application context
	 * 	@param data a data for put to clip board
	 * 
	 * */
	public static void put(Context context, int data) {		
		Clipboard.put(context, String.valueOf(data));			
	}
	
	
	@SuppressWarnings("deprecation")
	private static void put_API10(Context context, String text) {
		
		/* Get a link to the clip board manager object */
		android.text.ClipboardManager clManager =
			(android.text.ClipboardManager)
			//context.getSystemService(Context.CLIPBOARD_SERVICE);
			Clipboard.getClipboardManager(context);
		
		/* Put text to clip board */
		clManager.setText(text);					
	}
	
	@SuppressLint("NewApi")
	private static void put_API11(Context context, String text) {	
		
		/* Get a link to the clip board manager object */
		android.content.ClipboardManager clManager = 
				(android.content.ClipboardManager) 
				//context.getSystemService(Context.CLIPBOARD_SERVICE);
				Clipboard.getClipboardManager(context);
		
		/* Put text to clip board */
		clManager.setPrimaryClip(
				android.content.ClipData.newPlainText(SysConst.STR_EMPTY, 
						text));				
	}
		
	
	
	/*--------------------------------------------------------------------*/
	/* Checking a type of data into the clip board
	/*--------------------------------------------------------------------*/	
	
	/**
	 * Checks the clip board has data by mimeType.
	 * 
	 * 	@param context current application context
	 * 	@param mimeType a mime type for a checking
	 * 
	 *  @return True, if clip board has data with {@code mimeType}.
	 *  
	 * */
	@SuppressLint("NewApi")
	protected static boolean hasMimeType(Context context, String mimeType) {
				
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB)
			return false;
		
		/* Get a link to the clip board manager object */
		android.content.ClipboardManager clManager = 
				(android.content.ClipboardManager) 
				Clipboard.getClipboardManager(context);
					
		/* Checking a MIME type of clip board data */
		if (clManager.hasPrimaryClip())
			return clManager.getPrimaryClipDescription().hasMimeType(mimeType);
		
		/* Return a value */
		return false;
		
	}
	
	/**
	 * Checks the clip board has plain text.
	 * 
	 * 	@param context current application context
	 * 
	 * 	@return True, if clip board has plain text.
	 * 
	 * */
	public static boolean hasPlainText(Context context) {		
				
		/* Checking a SDK version and checking data type into the clip board */
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {			
			return Clipboard.hasPlainText_API11(context);
		} else
			return Clipboard.hasPlainText_API10(context);
							
	}
		
	/**
	 * Checks the clip board has plain text (for API 10).
	 * 
	 * 	@param context current application context
	 * 
	 * 	@return True, if clip board has plain text.
	 * 
	 * */	
	@SuppressWarnings("deprecation")
	private static boolean hasPlainText_API10(Context context) {		
		return ((android.text.ClipboardManager) 
				Clipboard.getClipboardManager(context)).hasText();		
	}
		
	/**
	 * Checks the clip board has plain text (for API 11).
	 * 
	 * 	@param context current application context
	 * 
	 * 	@return True, if clip board has plain text.
	 * 
	 * */	
	@SuppressLint("NewApi")
	private static boolean hasPlainText_API11(Context context) {		
		return Clipboard.hasMimeType(context, 
				android.content.ClipDescription.MIMETYPE_TEXT_PLAIN);		
	}
		
	/*--------------------------------------------------------------------*/
	/* Get data from the clip board
	/*--------------------------------------------------------------------*/
	
}
