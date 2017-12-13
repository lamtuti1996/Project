/**
 * 
 */
package com.azplay.azpotal.azgate.sc.util;

import com.google.gson.Gson;

//import com.google.gson.Gson;

import spark.ResponseTransformer;

/**
 * @author thang
 *
 */

public class JsonTransformer implements ResponseTransformer {

	private Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }
}
