package seminars.fourth.httpqueries;

public class HttpClient {

    public String get(String url){
        //Например
        String httpReply=url +
                        "<!doctype html>\n" +
                         "<html dir=\"ltr\" lang=\"ru\"\n" +
                         "    chrome-refresh-2023>\n" +
                         "  <head>\n" +
                         "    <meta charset=\"utf-8\">\n" +
                         "    <title>Новая вкладка</title>\n" +
                         "    <style>\n" +
                         "      body {\n" +
                         "        background: #FFFFFF;\n" +
                         "        margin: 0;\n" +
                         "      }\n" +
                         "\n" +
                         "      #backgroundImage {\n" +
                         "        border: none;\n" +
                         "        height: 100%;\n" +
                         "        pointer-events: none;\n" +
                         "        position: fixed;\n" +
                         "        top: 0;\n" +
                         "        visibility: hidden;\n" +
                         "        width: 100%;\n" +
                         "      }\n" +
                         "\n" +
                         "      [show-background-image] #backgroundImage {\n" +
                         "        visibility: visible;\n" +
                         "      }\n" +
                         "    </style>\n" +
                         "  </head>\n" +
                         "  <body>\n" +
                         "    <iframe id=\"backgroundImage\" src=\"\"></iframe>\n" +
                         "    <ntp-app></ntp-app>\n" +
                         "    <script type=\"module\" src=\"new_tab_page.js\"></script>\n" +
                         "    <link rel=\"stylesheet\" href=\"chrome://resources/css/text_defaults_md.css\">\n" +
                         "    <link rel=\"stylesheet\" href=\"chrome://theme/colors.css?sets=ui,chrome\">\n" +
                         "    <link rel=\"stylesheet\" href=\"shared_vars.css\">\n" +
                         "  </body>\n" +
                         "</html>";
        return httpReply;
    }

}
