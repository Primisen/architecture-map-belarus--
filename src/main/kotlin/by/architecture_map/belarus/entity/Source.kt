package by.architecture_map.belarus.entity

import jakarta.persistence.Entity

@Entity
data class Source(

    var name: String,
    var url: String,
    var description: String? = null

) : BaseEntity()
