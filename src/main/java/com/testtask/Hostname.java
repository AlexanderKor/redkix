package com.testtask;

/**
 * Created by O. Korniev on 14.09.2017.
 */

public class Hostname {
    public static final String TESTTASK_HOST_NAME = "staging.redkix.com/";


    public static String loginPageLink(){
        String internal = "https://" + TESTTASK_HOST_NAME;
        return internal;
    }

}
