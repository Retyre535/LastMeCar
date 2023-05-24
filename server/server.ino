#include <ESP8266WiFi.h>
#include <ESP8266WebServer.h>
#include <DNSServer.h>

ESP8266WebServer server(80);
DNSServer dnsServer;

const char* AP_NAME = "Robot_535";
const char* PASSWORD = "12340987";
IPAddress addr = IPAddress(192, 168, 4, 1);
IPAddress addrMask = IPAddress(255, 255, 255, 0);

void setup() {
  Serial.begin(9600);

  WiFi.setHostname(AP_NAME);
  WiFi.mode(WIFI_AP);
  WiFi.persistent(false);
  WiFi.softAPConfig(addr, addr, addrMask);
  WiFi.softAP(AP_NAME, PASSWORD);
  delay(100);

  dnsServer.start(53, "*", addr);

  server.on("/", handle_root);
  server.on("/up", handle_up);
  server.on("/down", handle_down);
  server.on("/left", handle_left);
  server.on("/right", handle_right);
  server.on("/play", handle_play);
  server.on("/noplay", handle_noplay);
  server.onNotFound(handle_root);

  server.begin();
}

void loop() {
  server.handleClient();
  dnsServer.processNextRequest();
}

void handle_root() {
  send_HTML();
}

void handle_up() {
  send_command(1);
  send_HTML();
}

void handle_down() {
  send_command(2);
  send_HTML();
}

void handle_left() {
  send_command(3);
  send_HTML();
}

void handle_right() {
  send_command(4);
  send_HTML();
}

void handle_play() {
  send_command(5);
  send_HTML();
}

void handle_noplay() {
  send_command(6);
  send_HTML();
}

void send_command(byte commandNumber) {
  Serial.print(commandNumber);
}

const char html_common_page[] PROGMEM = R"====(<!DOCTYPE html>
<html lang="en" class="">
<head>
    <meta charset='utf-8' />
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no" />
    <title>MirtekGW - _UNIT_NAME_</title>
    <style>
        div,fieldset,input,select {padding: 5px;font-size: 1em;}
        .main {text-align:left;display: inline-block;min-width:340px;color: #eaeaea;}
        fieldset {background-color: #4f4f4f;}
        p {margin: 0.5em 0;}
        input[type=checkbox],input[type=radio] {width: 1em;margin-right: 6px;vertical-align: -1px;}
        input[type=range] {width: 99%;}
        input:not([type]),input[type=password],input[type=number]  {width: 100%;box-sizing: border-box;-webkit-box-sizing: border-box;-moz-box-sizing: border-box;background: #dddddd;color: #000000;}
        select {width: 100%;background: #dddddd;color: #000000;block-size: 40px;}
        textarea {resize: none;width: 98%;height: 318px;padding: 5px;overflow: auto;background: #1f1f1f;color: #65c115;}
        body {text-align: center;font-family: verdana,sans-serif;background: #252525;}
        td {padding: 0px;}
        button, a.button {display: inline-block;text-align: center;border: 0;border-radius: 0.3rem;background: #1fa3ec;color: #faffff;line-height: 2.4rem;font-size: 1.2rem;width: 100%;-webkit-transition-duration: 0.4s;transition-duration: 0.4s;cursor: pointer;}
        button:hover, a.button:hover {background: #0e70a4;}
        .bred {background-color: #d43535;}
        .bred:hover {background-color: #931f1f;}
        .bgrn {background-color: #47c266;}
        .bgrn:hover {background-color: #5aaf6f;}
        a {text-decoration: none;}
        .p {float: left;text-align: left;}
        .q {float: right;text-align: right;}
        a {color: #1fa3ec;text-decoration: none;}
        .p {float: left;text-align: left;}
        .q {float: right;text-align: right;}
        .r {border-radius: 0.3em;padding: 2px;margin: 6px 2px;}
        span {display: inline-block;}
        h2, h3 {text-align: center;}
    </style>
</head>
<body>
    <div class="main">
      <div>
        <fieldset>
          <legend><b>&nbsp; Управление &nbsp;</b></legend>
          <p></p>
          <a class='button back' href='/up'>Вверх</a>
          <p></p>
          <a class='button back' href='/down'>Вниз</a>
          <p></p>
          <a class='button back' href='/left'>Влево</a>
          <p></p>
          <a class='button back' href='/right'>Вправо</a>
          <p></p>
          <a class='button back' href='/play'>Воспроизвести</a>
          <p></p>
          <a class='button back' href='/noplay'>Остановить</a>
        </fieldset>
      </div>
    </div>
</body>
</html>
)====";

void send_HTML()
{
  String pageContent = FPSTR(html_common_page);
  server.send(200, F("text/html"), pageContent);
}
