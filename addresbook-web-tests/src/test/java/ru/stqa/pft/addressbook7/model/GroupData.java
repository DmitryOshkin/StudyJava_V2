package ru.stqa.pft.addressbook7.model;

import java.util.Objects;

public class GroupData {
  private final String name;
  private final String header;
  private final String footer;

  public GroupData(String name, String header, String footer) {
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  @Override
  public String toString() {                            // Преобразование атрибута объекта в строку. Текстовое представление элемента
    return "GroupData{" +
            "name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {                               // Метод для сравнения объектов типа GroupData
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
