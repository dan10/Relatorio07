/*
  Relatório 7
  ULA - Arduino
  Teste dos programas em Java
*/

// Definição de valores para variáveis
int led10 = 10;
int led11 = 11;
int led12 = 12;
int led13 = 13;
String x;
byte A;
byte B;
char C;
String out;
byte resp;

void setup ( )
{
  Serial.begin(9600);
  pinMode(led10, OUTPUT);
  pinMode(led11, OUTPUT);
  pinMode(led12, OUTPUT);
  pinMode(led13, OUTPUT);
}// fim setup ( )

void mostrar (char x, int led)
{
  if (x == '1')
    digitalWrite(led, HIGH);
  else if (x == '0')
    digitalWrite(led, LOW);
}// fim mostrar ( )

byte cvtChar (char c)
{
  byte b = 0;
  
  if (c > 47 && c < 58)
    b = c - 48;
  else if (c > 64 && c < 71)
    b = c - 55;
  else
    Serial.println("[ERRO] Entrada invalida!!");
  
  return (b);
}// fim cvtChar

void loop ( )
{
  if (Serial.available( ) > 0)
  {
    x = Serial.readString( );
    
    A = cvtChar(x.charAt(0));
    B = cvtChar(x.charAt(1));
    C = x.charAt(2);
    
    switch (C)
    {
      case '0':
        resp = ~A;
        break;
      case '1':
        resp = ~(A|B);
        break;
      case '2':
        resp = (~A)&B;
        break;
      case '3':
        resp = 0;
        break;
      case '4':
        resp = ~(A&B);
        break;
      case '5':
        resp = ~B;
        break;
      case '6':
        resp = A^B;
        break;
      case '7':
        resp = A&(~B);
        break;
      case '8':
        resp = (~A)|B;
        break;
      case '9':
        resp = ~(A^B);
        break;
      case 'A':
        resp = B;
        break;
      case 'B':
        resp = A&B;
        break;
      case 'C':
        resp = 15;
        break;
      case 'D':
        resp = A|(~B);
        break;
      case 'E':
        resp = A|B;
        break;
      case 'F':
        resp = A;
        break;
      default:
        Serial.println("[ERRO] Operacao invalida!!");
        break;
    }
    
    out = String(resp|128,BIN);
    
    mostrar(out.charAt(4), led13);
    mostrar(out.charAt(5), led12);
    mostrar(out.charAt(6), led11);
    mostrar(out.charAt(7), led10);
    
    //if (Serial.read( ) == '\n')   // ignorar
  }
}// fim loop ( )
