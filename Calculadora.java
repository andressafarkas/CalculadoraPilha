public class Calculadora {

    Pilha p = new Pilha();

    public double Res_parcial(double a, double b, char operacao){
        double res = 0;
        if(operacao == '+'){
            res = a + b;
        }else  if(operacao == '-'){
            res = a - b;
        }else  if(operacao == '*'){
            res = a * b;
        }else  if(operacao == '/'){
            res = a / b;
        } if(operacao == '^'){
            res = Math.pow(a, b);
        }else{
            System.out.println("Erro de sintaxe encontrado!");
        }
        return res;
    }

    public double Calcula(){
        Pilha aux = new Pilha();
        int tam = p.size();
        double resposta = 0;
        char operacao;
        char x = ' ';

        for (int i = 0; i < tam; i++) {  // adiciona a expressao na fila
            p.push(x);
        }

        while (p.size() != 1){  // enquanto o tam da fila for diferente de 1
            if (p.top() == '}'){
                aux.push(p.pop()); // adiciona } na fila aux
                if(p.top() == ']'){
                    aux.push(p.pop());  // adiciona ] na fila auxiliar
                }else if (p.top() == ')'){ // adiciona ) na fila auxiliar
                    aux.pop(); // remove o ultimo ')'
                    int a = p.pop();
                    operacao = p.pop();
                    int b = p.pop();
                    resposta = Res_parcial(a, b, operacao);
                    p.pop();  // remove o caracter de abertura
                    aux.push((char)resposta);  // adiciona o resultado parcial na fila auxiliar
                }
                for (int i = 0; i < tam; i++) {
                    aux.push(p.pop());  // adiciona o restante dos elementos na pilha auxilar
                }
                for (int i = 0; i < tam; i++) {
                    p.push(aux.pop());  // retorna os elementos pra pilha principal com o resultado calculado
                } 

            }else if (p.top() == ']'){
                aux.push(p.pop()); // adiciona ] na fila aux
                if(p.top() == ')'){
                    aux.push(p.pop());  // adiciona ) na fila auxiliar
                }else{
                    aux.pop(); // remove o ultimo ')'
                    int a = p.pop();
                    operacao = p.pop();
                    int b = p.pop();
                    resposta = Res_parcial(a, b, operacao);
                    p.pop();  // remove o caracter de abertura
                    aux.push((char)resposta);  // adiciona o resultado parcial na fila auxiliar
                }
                for (int i = 0; i < tam; i++) {
                    aux.push(p.pop());  // adiciona o restante dos elementos na pilha auxilar
                }
                for (int i = 0; i < tam; i++) {
                    p.push(aux.pop());  // retorna os elementos pra pilha principal com o resultado calculado
                } 

            }else if(p.top() == ')'){
                p.pop();  // remove ) 
                int a = p.pop();
                operacao = p.pop();
                int b = p.pop();
                resposta = Res_parcial(a, b, operacao);
                p.pop();  // remove o caracter de abertura
                aux.push((char)resposta);

            }else{
                if (p.size() != 1){  // se o tamanho da pilha for diferente de 1
                    System.out.println("Erro de sintaxe encontrado!");
                    break;
                }else{
                    return p.top();
                }
            }
        }
        return (double)p.top();
    }
}
