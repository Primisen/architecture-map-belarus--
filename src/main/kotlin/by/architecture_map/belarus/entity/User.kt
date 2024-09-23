package by.architecture_map.belarus.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
/**
 * In application using PostgreSQL DB in which 'user' is reserved keyword,
 * so table has short name 'usr'
 */
@Table(name = "usr")
data class User(
    var username: String? = null,
    var password: CharArray? = null,
    var name: String? = null,
    var surname: String? = null,
    var aboutThemself: String? = null,

    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "role_user",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")]
    )
    var roles: Set<Role> = setOf(),

) : BaseEntity() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (username != other.username) return false
        if (password != null) {
            if (other.password == null) return false
            if (!password.contentEquals(other.password)) return false
        } else if (other.password != null) return false
        if (roles != other.roles) return false

        return true
    }

    override fun hashCode(): Int {
        var result = username?.hashCode() ?: 0
        result = 31 * result + (password?.contentHashCode() ?: 0)
        result = 31 * result + roles.hashCode()
        return result
    }
}
