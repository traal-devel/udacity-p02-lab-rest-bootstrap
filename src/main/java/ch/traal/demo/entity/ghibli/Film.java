package ch.traal.demo.entity.ghibli;

public class Film {

  /* member variables */
  private String id = null;
  private String title = null;
  private String description = null;
  private String director = null;
  private String producer = null;
  private Integer release_date = null;
  private Integer rt_score = null;

  /* constructors */
  public Film() {
    super();
  }

  /* methods */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getProducer() {
    return producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }

  public Integer getRelease_date() {
    return release_date;
  }

  public void setRelease_date(Integer release_date) {
    this.release_date = release_date;
  }

  public Integer getRt_score() {
    return rt_score;
  }

  public void setRt_score(Integer rt_score) {
    this.rt_score = rt_score;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
