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

	
	
		public boolean removeValor(int valor) {
	    // caso a lista esteja vazia
	    if (this.inicio == null) {
	        return false;
	    }

	    // caso a lista tenha apenas um elemento
	    if (this.inicio.getProx() == null) {
	        if (this.inicio.getValor() == valor) {
	            this.inicio = null;
	            return true;
	        } else {
	            return false;
	        }
	    }

	    // lista com dois ou mais elementos
	    Nodo aux = this.inicio;
	    while (aux != null) {
	        if (aux.getValor() == valor) {
	            // se houver um nodo anterior
	            if (aux.getAnt() != null) {
	                aux.getAnt().setProx(aux.getProx());
	            } else {
	                // se o elemento for o primeiro
	                this.inicio = aux.getProx();
	            }

	            // se houver um nodo seguinte
	            if (aux.getProx() != null) {
	                aux.getProx().setAnt(aux.getAnt());
	            }

	            return true; // valor removido com sucesso
	        }

	        aux = aux.getProx();
	    }

	    return false; // valor não encontrado na lista
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
