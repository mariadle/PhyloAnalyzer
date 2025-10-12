package aled.upm.es.recursividad;
import java.util.ArrayList;
import java.util.List;
	
	/**
	 * Representa un nodo en el árbol filogenético (una especie, género, familia, etc.).
	 * La estructura es inherentemente recursiva: cada nodo contiene una lista de otros nodos.
	 */
	public class TaxonNode {
	    private final String name;
	    private final List<TaxonNode> children;
	    private TaxonNode parent;

	    // Constructor
	    public TaxonNode(String name) {
	        this.name = name;
	        this.children = new ArrayList<>();
	        this.parent = null; // La raíz no tiene padre
	    }

	    // Método para construir el árbol (agrega un nuevo TaxonNode como hijo)
	    public void addChild(TaxonNode child) {
	        this.children.add(child);
	        child.setParent(this);
	    }

	    // Getters
	    public String getName() {
	        return name;
	    }

	    public List<TaxonNode> getChildren() {
	        return children;
	    }

	    public TaxonNode getParent() {
	        return parent;
	    }

	    // Setter (usado solo por addChild)
	    private void setParent(TaxonNode parent) {
	        this.parent = parent;
	    }

	    //Devuelve el camino desde este nodo hasta la raíz (imprime ancestros)
	   
	    public List<String> getAncestors() {
	        List<String> ancestors = new ArrayList<>();
	        TaxonNode current = this;
	        while (current.getParent() != null) {
	            ancestors.add(0, current.getParent().getName()); // Añade al inicio de la lista
	            current = current.getParent();
	        }
	        return ancestors;
	    }
	}

