package proyecto.escalab.microproducto.model;
/*
 * Aplicativo desarrollado para la clase de Java Expert
 * Autor: Cedric Bardalez (CJava Perú)
 * Version 1.0
 * www.cjavaperu.com
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "producto")
public class Producto {
	
	@Id 
	private String codigo;
	private String nombre;
	private String marca;
	private Integer unidades;
	private Double precioUnitario;
	private String descripcion;
	
	public Producto() {}

	public Producto(String codigo, String nombre, String marca, Integer unidades, Double precioUnitario, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.marca = marca;
		this.unidades = unidades;
		this.precioUnitario = precioUnitario;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getUnidades() {
		return unidades;
	}
	
	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}