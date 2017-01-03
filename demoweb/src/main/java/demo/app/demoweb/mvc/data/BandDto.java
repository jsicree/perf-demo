package demo.app.demoweb.mvc.data;

public class BandDto {
	private Integer id;
	private String name;
	private Genre genre;

	public BandDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BandDto(Integer id, String name, Genre genre) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "BandDto [id=" + id + ", name=" + name + ", genre=" + genre + "]";
	}

}
