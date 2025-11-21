package fr.isima.master1.genielog.featureflipping.domain;

public record Role(String name) {

    public Role {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Cannot create a role without name");
        if (!name.matches("^[A-Za-z][A-Za-z0-9_-]*?[A-Za-z0-9]$"))
            throw new IllegalArgumentException("Invalid role name : \"" + name + "\"");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return name.equalsIgnoreCase(role.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

}
