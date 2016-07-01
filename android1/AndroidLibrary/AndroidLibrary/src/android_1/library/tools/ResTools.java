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

package android_1.library.tools;

import android.content.Context;
import android.content.res.Resources;

/**
 * Class that contains some methods for working with a resources.
 * 
 * @author Mikhail Malakhov
 * 
 * */
public class ResTools {

	/**
	 * Gets the id of resources by type and name.
	 * 
	 * 	@param res a link to the resource object
	 * 	@param resPackage name of resource package
	 * 	@param resType type of resource
	 * 	@param resName name of resource
	 * 
	 * 	@return Id of resource that was described by type and name. 
	 * 
	 * */
	public static int getResIdByName(Resources res, String resPackage, 
			String resType, String resName) {		
		return res.getIdentifier(resName, resType, resPackage);								
	}
	
	/**
	 * Gets the id of resources by type and name.
	 * 
	 * 	@param context application context
	 * 	@param resType type of resource
	 * 	@param resName name of resource
	 * 
	 * 	@return Id of resource that was described by type and name. 
	 * 
	 * */	
	public static int getResIdByName(Context context, String resType, 
			String resName) {		
		return ResTools.getResIdByName(context.getResources(), 
				context.getPackageName(), resType, resName);		
	}
	
}
