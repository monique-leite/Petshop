package Steps;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


public class Servico {

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void tc_01_incluir_usuario() throws IOException {
        String resultado = "119870718";

        String jsonBody = lerJson("src/test/resources/usuario.json");

        given() // Dado que
                .contentType("application/json") // Tipo do conteudo REST é sempre assim
                // Existem serviços ASMX e outros, o formato seria text/xml
                .log().all()                     // Gerar um log completo
                // {"id":1

                .body(jsonBody)
                .when()
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .log().all()
                .statusCode(200) // Teste de Interoperabilidade (Conectou)
                .body("code",is(200))
                .body("type",is("unknown"))
                .body("message",is(resultado))

        ;

    }

    @Test
    public void tc_02_consultar_usuario() throws IOException {
        String resultado = "119870718";

        //String jsonBody = lerJson("src/test/resources/usuario.json");

        given() // Dado que
                .contentType("application/json") // Tipo do conteudo REST é sempre assim
                // Existem serviços ASMX e outros, o formato seria text/xml
                .log().all()                     // Gerar um log completo
                // {"id":1

                //.body(jsonBody)
                .when()
                .get("https://petstore.swagger.io/v2/user/AnaClaraMS")
                .then()
                .log().all()
                .statusCode(200) // Teste de Interoperabilidade (Conectou)
        //.body("code",is(200))
        //.body("type",is("unknown"))
        //.body("message",is(resultado))

        ;

    }

    @Test
    public void tc_03_alterar_usuario() throws IOException {
        String resultado = "119870718";

        String jsonBody = lerJson("src/test/resources/usuario2.json");

        given() // Dado que
                .contentType("application/json") // Tipo do conteudo REST é sempre assim
                // Existem serviços ASMX e outros, o formato seria text/xml
                .log().all()                     // Gerar um log completo
                // {"id":1

                .body(jsonBody)
                .when()
                .put("https://petstore.swagger.io/v2/user/AnaClaraMS")
                .then()
                .log().all()
                .statusCode(200) // Teste de Interoperabilidade (Conectou)
                .body("code",is(200))
                .body("type",is("unknown"))
                .body("message",is(resultado))

        ;

    }

    @Test
    public void tc_04_excluir_usuario() throws IOException {
        String resultado = "119870718";

        //String jsonBody = lerJson("src/test/resources/usuario.json");

        given() // Dado que
                .contentType("application/json") // Tipo do conteudo REST é sempre assim
                // Existem serviços ASMX e outros, o formato seria text/xml
                .log().all()                     // Gerar um log completo
                // {"id":1

                //.body(jsonBody)
                .when()
                .delete("https://petstore.swagger.io/v2/user/AnaClaraMS")
                .then()
                .log().all()
                .statusCode(404) // Teste de Interoperabilidade (Conectou)
        //.body("code",is(200))
        //.body("type",is("unknown"))
        //.body("message",is(resultado))

        ;

    }


}


