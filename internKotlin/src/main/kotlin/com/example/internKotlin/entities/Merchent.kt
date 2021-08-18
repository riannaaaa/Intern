package com.example.internKotlin.entities


/**
 * @author blueriver
 * @description 产品实体
 * @date 2018/2/6
 * @since 1.0
 */
//@Entity
//data class Merchent constructor(@Id val id: Int, val name: String) {
//
//}
import javax.persistence.*
import javax.validation.constraints.NotBlank

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-kotlin-article
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-04
 * Time: 06:16
 */
@Entity
@Table(name = "merchant")
data class Merchent(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int = 0,

    @Column(name = "name")
    @get: NotBlank
    val name: String = "",

    @Column(name = "day")
    @get: NotBlank
    val day: Int = 0,

) {
    override fun toString(): String {
        return "Merchent(id=$id, name='$name', day=$day)"
    }
}

