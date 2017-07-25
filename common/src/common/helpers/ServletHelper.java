//package common.helpers;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Enumeration;
//
///**
// * Created by Logan.Moen on 6/26/2017.
// */
//public class ServletHelper extends CommonHelper{
//
//    public static void logRequestParams(HttpServletRequest request) {
//        //notes:  Not gonna be pretty, need a good refactor and should be moved to common module
//
//        Enumeration<String> paramNameList = request.getParameterNames();
//        while(paramNameList.hasMoreElements()){
//            String paramName = paramNameList.nextElement();
//            String value = "";
//            for(String str : request.getParameterValues(paramName)) {
//                value += str;
//            }
//
//            logger.info("Parameter Name = " + paramName + " - Value(s) = " + value);
//        }
//
//    }
//}
