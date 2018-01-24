public class Node
{
    char l;
    public Node lf,rf;
    public Node( char l )
    {
        this.l = l;
        lf = rf = null;
    }

    public String toString() {
        return Character.toString(l);
    }
}
