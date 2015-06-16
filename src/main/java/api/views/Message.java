package api.views;

public enum Message {
	
	CREATED_RELATION("Relación entre recursos creada exitosamente."),
	NOT_CREATED_RELATION("Error al intentar crear una relación entre los recursos."),
	DELETED_RELATION("Relación entre recursos borrada exitosamente."),
	NOT_DELETED_RELATION("Error al intentar borrar una relación entre los recursos."),
	NOT_FOUND("Recurso no encontrado en el repositorio."),
	SELECTED ("Recurso obtenido exitosamente."),
	INSERTED ("Recurso insertado exitosamente."),
	DELETED  ("Recurso eliminado exitosamente."),
	UPDATED  ("Recurso actualizado exitosamente.");
	
	private final String message;
	
	private Message(String message) {
		this.message = message; }

	public String get() {
		return message; }
}