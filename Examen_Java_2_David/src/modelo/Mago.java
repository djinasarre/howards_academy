package modelo;

public abstract class Mago {
    protected String nombre;
    protected int fuerza;
    protected int inteligencia;
    protected int rapidez;
    protected int destreza;

    public Mago(String nombre, int fuerza, int inteligencia, int rapidez, int destreza) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.rapidez = rapidez;
        this.destreza = destreza;
    }
    
    public abstract void saludar();
    
    public boolean esMago() {
        return true;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public int getRapidez() {
		return rapidez;
	}

	public void setRapidez(int rapidez) {
		this.rapidez = rapidez;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}
	
	
	
	}
    
    
