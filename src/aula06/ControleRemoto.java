package aula06;

public class ControleRemoto implements Controlador {
    //atritubos
    private int volume;
    private boolean ligado;
    private boolean tocando;
    
    public ControleRemoto(){
        volume = 50;
        ligado = false;
        tocando = false;
    }
    //metodos especiais 
    
    private int getVolume(){
        return this.volume;
    }
    
    private void setVolume(int v){
        this.volume = v;
    }
    
    private boolean getLigado(){
        return this.ligado;
    }
    
    private void setLigado(boolean l){
        this.ligado = l;
    }
    
    private boolean getTocando(){
        return this.tocando;
    }
     
    private void setTocando(boolean t){
        this.tocando = t;
    }
    //metodos abstratos 
    @Override
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abriMenu() {
        if (this.getLigado()){
        System.out.println("------------MENU-------------");
        System.out.println("Esta ligado ? "+this.getLigado());
        System.out.println("Esta tocando ? "+this.getTocando());
        System.out.print("Volume:"+this.getVolume());
        
        for (int i=0; i<= this.getVolume(); i+=10){
            System.out.print("|");
        }
        System.out.println("");
        System.out.println("-------------------------------");
        }
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando Menu...");
    }

    @Override
    public void maisVolume() {
        if (getLigado()){
            this.setVolume(this.getVolume()+5);
        }else{
            System.out.println("Impossível aumentar volume");
        }
    }

    @Override
    public void menosVolume() {
        if (this.getLigado()){
            this.setVolume(this.getVolume()-5);
        }else{
            System.out.println("Impossível Diminuir volume");
        }
    }

    @Override
    public void ligarMudo() {
        if (this.getLigado() && this.getVolume() > 0){
            this.setVolume(0);
        }
    }

    @Override
    public void desligarMudo() {
        if (this.getLigado() & this.getVolume() == 0){
            this.setVolume(50);
        }
    }

    @Override
    public void play() {
        if (this.getLigado() && !(this.getTocando())){
            this.setTocando(true);
        }else{
            System.out.println("Não consigo reproduzir");
        }
    }

    @Override
    public void pause() {
        if (this.getLigado() && this.getTocando()){
            this.setTocando(false);
        }else{
            System.out.println("Não consigo pauser");
        }
    }
}
