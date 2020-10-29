package org.insset.shared;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> packing because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is note translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

    /**
     * Verifies that the specified name is valid for our service.
     *
     * In this example, we only require that the name is at least four
     * characters. In your application, you can use more complex checks to
     * ensure that usernames, passwords, email addresses, URLs, and other fields
     * have the proper syntax.
     *
     * @param name the name to validate
     * @return true if valid, false if invalid
     */
    public static boolean isValidName(String name) {
        if ((name == null) || (name.isEmpty())) {
            return false;
        }
        return true;
    }

    /**
     * Verifies that the specified value is valide.
     *
     * In this example, we only require that the name is at least four
     * characters. In your application, you can use more complex checks to
     * ensure that usernames, passwords, email addresses, URLs, and other fields
     * have the proper syntax.
     *
     * @param prix
     * @param name the name to validate
     * @return true if valid, false if invalid
     */
    public static boolean isValidPrix(Float prix) {
        return prix instanceof Float;
    }
    
    public static boolean isValidTaux(Integer nbr) {
        return !((nbr > 100 || nbr < 0) || nbr instanceof Integer);
    }
    
    public static boolean isValidDecimal(Integer nbr) {
        return nbr instanceof Integer;
    }

    public static boolean isValidRoman(String nbr) {
//        Pattern p = Pattern.compile("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
//        Matcher m = p.matcher(nbr);
//        Boolean bool = m.matches();
     return true;
    }

    public static boolean isValidDate(String date) {
//        if(date == null){
//            return false;
//	}
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//	sdf.setLenient(false);
//        try {
////            if not valid, it will throw ParseException
//            Date dateAVerifier = sdf.parse(date);
//            System.out.println(dateAVerifier);
//
//	} catch (ParseException e) {
//
//			return false;
//		}
        return true;
    }
    
}
