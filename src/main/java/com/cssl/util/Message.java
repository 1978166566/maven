package com.cssl.util;

public class Message {
    public static String getMassage(String str,String dizhi){
        StringBuffer sb = new StringBuffer();
        sb.append("<script type='text/javascript'>");
        sb.append("alert('"+str+"');");
        sb.append("window.location = '"+dizhi+"';");
        sb.append("</script>");
        return sb.toString();
    }
}
