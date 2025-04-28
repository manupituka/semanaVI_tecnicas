package duplamenteEncadeada;

public class ListaDuplamenteEncadeada {
//  getters e setters
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
		Nodo novo = new Nodo(valor, null, null); 

		// caso a lista esteja VAZIA
		if (this.inicio == null) {
			this.inicio = novo; 
			return;
		}

		//se a lista NÃO esta vazia
		Nodo aux = this.inicio; 
		Nodo anterior = null;  
		while (aux != null && aux.getValor() < valor) { 
			anterior = aux; 
			aux = aux.getProx(); 
		}

		// verifica se há valor existente 
		if (aux != null && aux.getValor() == valor) {
			System.out.println("Valor já existente na lista. Inserção não realizada.");
			return;
		}

		if (anterior == null) { // Se anterior ainda é null, o novo valor deve ser inserido no início da lista (é o menor valor)
			novo.setProx(this.inicio); 
			this.inicio.setAnt(novo); 
			this.inicio = novo; 
		}

		else { // insere no meio ou fim da lista
			novo.setProx(aux);
			novo.setAnt(anterior);
			anterior.setProx(novo); 
			if (aux != null) {
				aux.setAnt(novo); // se não for o final da lista, atualiza o anterior do próximo
			}
		}
	}

	
	public void imprime() {
		if (this.inicio == null)
			System.out.println("Lista vazia!");
		else {
			int count = 0; 
			Nodo aux = this.inicio;
			while (aux != null) { // percorre a lista até o final
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
			boolean encontrou = false; 
			
			if (this.inicio.getProx() == null) { // lista com um nodo apenas
				if (this.inicio.getValor() == valor) { // valor corresponde com a busca
					System.out.println("Valor " + this.inicio.getValor() + " removido!");
					this.inicio = null; // limpeza do nodo
					encontrou = true;
				}
			}
			
			else { // lista com mais de um valor
				Nodo aux = this.inicio;
				while (aux != null) { // percorre toda a lista até encontrar o valor desejado
					if (aux.getValor() == valor) {
						encontrou = true;
						System.out.println("Valor " + aux.getValor() + " removido!");
						
						if (aux.getAnt() != null) { // se nodo a ser removido tiver um nodo antes
							aux.getAnt().setProx(aux.getProx()); 
						
						} else { // se não tiver nenhum nodo anterior
							this.inicio = aux.getProx(); 
						}
						
						if (aux.getProx() != null) { 
							aux.getProx().setAnt(aux.getAnt()); 
						}
						aux.setProx(null);
						aux.setAnt(null);
						aux = null;  
						break;
					}
					aux = aux.getProx(); 
				}
			}
			if (!encontrou) // encontrou = false
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
