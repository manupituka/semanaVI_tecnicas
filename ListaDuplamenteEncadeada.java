package duplamenteEncadeada;

public class ListaDuplamenteEncadeada {
// criar variavel inicio e seus getters e setters
	private Nodo inicio;

	public ListaDuplamenteEncadeada() {
		this.setInicio(null);
	}

	public Nodo getInicio() {
		return inicio;
	}

	public void setInicio(Nodo inicio) {
		this.inicio = inicio;
	}

	public void insereOrdenado(int valor) {
		Nodo novo = new Nodo(valor, null, null); // instancia novo nodo

		// caso a lista esteja VAZIA
		if (this.inicio == null) {
			this.inicio = novo; // ponteiro 'inicio' passa a apontar para o novo nodo
			return;
		}

		//se a lista NÃO esta vazia
		Nodo aux = this.inicio; // aux percorre a lista
		Nodo anterior = null;  // aponta pro nodo que vem antes do aux

		while (aux != null && aux.getValor() < valor) { // enquanto inicio não for nulo e o valor for maior que o aux percorrido
			anterior = aux; 
			aux = aux.getProx(); // anda para o próximo nodo
		}

		// valor já existe? não pode haver duplicatas
		if (aux != null && aux.getValor() == valor) {
			System.out.println("Valor já existente na lista. Inserção não realizada.");
			return;
		}

		if (anterior == null) { // valor é menor que todos da lista, logo vai ser inserido no INÍCIO
			novo.setProx(this.inicio); // coloca no inicio o novo nodo
			this.inicio.setAnt(novo); // anterior aponta para o novo nodo
			this.inicio = novo; // ponteiro 'inicio' passa a apontar para o novo nodo
		}

		else { // insere no meio ou fim da lista
			novo.setProx(aux);
			novo.setAnt(anterior);
			anterior.setProx(novo); // nodo anterior aponta pro novo
			if (aux != null) {
				aux.setAnt(novo); // se não for o final da lista, atualiza o anterior do próximo
			}
		}
	}

	
	public void imprime() {
		if (this.inicio == null)
			System.out.println("Lista vazia!");
		else {
			int count = 0; // contador que diz a posição
			Nodo aux = this.inicio;
			while (aux != null) { // percorre a lista até o inicio ser nulo
				System.out.println("Valor: " + aux.getValor() + " Posição: " + count);
				aux = aux.getProx();
				count++;
			}
		}
	}

	
	
	public void removeValor(int valor) {

		// lista vazia
		if (this.inicio == null)
			System.out.println("Lista vazia!");

		else { // não vazia
			boolean encontrou = false; // inicializa boolean como false
			
			if (this.inicio.getProx() == null) { // lista com um nodo apenas
				if (this.inicio.getValor() == valor) { // valor corresponde com a busca
					System.out.println("Valor " + this.inicio.getValor() + " removido!");
					this.inicio = null; // remove nodo
					encontrou = true;
				}
			}
			
			else { // lista com mais de um valor
				Nodo aux = this.inicio;
				while (aux != null) { // percorre toda a lista até encontrar o valor desejado
					if (aux.getValor() == valor) {
						encontrou = true;
						System.out.println("Valor " + aux.getValor() + " removido!");
						
						if (aux.getAnt() != null) { // se nodo a ser removido tiver um nodo antes, conecta ele ao próximo
							aux.getAnt().setProx(aux.getProx()); // faz com que o nodo anterior aponte para o próximo
						
						} else { // se não tiver nenhum nodo anterior, apenas o proximo
							this.inicio = aux.getProx(); // o apontador 'inicio' aponta para o próximo nodo 
						}
						
						if (aux.getProx() != null) { // se nodo a ser removido tiver um nodo após
							aux.getProx().setAnt(aux.getAnt()); //  nodo proximo aponta para anterior 
						}
						aux.setProx(null);
						aux.setAnt(null);
						aux = null; // limpeza do nodo aux (lixeira java vai coletar)
						break;
					}
					aux = aux.getProx(); // se o valor não for encontrado e vai procurar no próximo nodo
				}
			}
			if (encontrou == false) // encontrou = false
				System.out.println("Valor não encontrado na LDE!");
		}
	}

	public void pesquisaValor(int valor) {
		if (this.inicio == null) {
			System.out.println("Lista vazia!");
		} 
		else {
			Nodo aux = this.inicio;
			int count = 0;
			boolean encontrado = false;

			while (aux != null) {
				if (aux.getValor() == valor) {
					System.out.println("Valor " + valor + " encontrado na posição " + count);
					encontrado = true;
					break;
				}
				aux = aux.getProx();
				count++;
			}

			if (!encontrado) {
				System.out.println("Valor " + valor + " não encontrado na lista.");
			}
		}
	}
}
