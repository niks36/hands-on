package tesco.container;

public enum ContainerType {

  SMALL(10L,10L,10L),
  MEDIUM(10L,10L,10L),
  LARGE(10L,10L,10L),;

  Long height;
  Long width;
  Long depth;

  ContainerType(Long height, Long width, Long depth) {
    this.height = height;
    this.width = width;
    this.depth = depth;
  }
}
