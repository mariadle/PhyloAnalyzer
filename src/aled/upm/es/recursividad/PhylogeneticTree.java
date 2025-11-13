package aled.upm.es.recursividad;
import java.util.List;
public class PhylogeneticTree {

	private TaxonNode root;

    // Crea un árbol con una raíz
    public PhylogeneticTree(String rootName) {
        this.root = new TaxonNode(rootName);
    }

    // Devuelve la raíz
    public TaxonNode getRoot() {
        return root;
    }

    /**
     * Busca un nodo por nombre empezando desde la raíz.
     * Devuelve el TaxonNode si lo encuentra, o null si no está.
     */
    public TaxonNode find(String name) {
        return findRecursive(root, name);
    }

    // Búsqueda recursiva en profundidad (DFS)
    private TaxonNode findRecursive(TaxonNode current, String name) {
        if (current == null) {
            return null;
        }
        if (current.getName().equals(name)) {
            return current;
        }
        // Miramos recursivamente en los hijos
        for (TaxonNode child : current.getChildren()) {
            TaxonNode found = findRecursive(child, name);
            if (found != null) {
                return found;
            }
        }
        return null; // no se encontró 
    }

    /**
     * Añade un nuevo taxón como hijo de otro existente.
     * @param parentName nombre del padre
     * @param childName  nombre del nuevo hijo
     * @return true si se ha añadido, false si no se encontró el padre
     */
    public boolean addTaxon(String parentName, String childName) {
        TaxonNode parent = find(parentName);
        if (parent == null) {
            return false; // el padre no se ha encontrado
        }
        TaxonNode child = new TaxonNode(childName);
        parent.addChild(child);
        return true;
    }

    
    public void printTree() {
        printRecursive(root, 0);
    }

    private void printRecursive(TaxonNode node, int level) {
        if (node == null) return;

        // sangrado según el nivel
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println("- " + node.getName());

        // imprimir recursivamente los hijos
        for (TaxonNode child : node.getChildren()) {
            printRecursive(child, level + 1);
        }
    }

}
