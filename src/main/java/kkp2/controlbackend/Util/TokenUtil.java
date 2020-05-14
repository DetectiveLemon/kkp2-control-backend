package kkp2.controlbackend.Util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import kkp2.controlbackend.Bean.User;

import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    private static final String TOKEN_SECRET = "DETECTIVELEONTESTJWT";

    public static String getToken(User user){
        String token = "";
        //加密算法及密钥
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        Map<String,Object> header = new HashMap<>();
        //头部信息
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        //携带信息
        token = JWT.create()
                .withHeader(header)
                .withClaim("user_id", user.getUser_id())
                .withClaim("user_name", user.getUser_name())
                .withClaim("password", user.getUser_type())
                .sign(algorithm);
        return token;
    }

    public static boolean veryify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            Map<String, Claim> Claims  = jwt.getClaims();
            System.out.println(jwt.getClaim("username").asString());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
//        TokenUtil test = new TokenUtil();
//        String token = test.getToken(1, "admin", 0);
//        System.out.println(token);
//        System.out.println(test.veryify(token+"A"));
    }
}
