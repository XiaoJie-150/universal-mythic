package ink.ptms.um

import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.inventory.ItemStack

interface Mythic {

    /** 是否 4.X 版本 */
    val isLegacy: Boolean

    /** 获取 MythicItem 实例 */
    fun getItem(name: String): Item?

    /** 获取 ItemStack 所对应的 MythicItem ID */
    fun getItemId(itemStack: ItemStack): String?

    /** 获取 MythicItem 实例并构建到 ItemStack */
    fun getItemStack(name: String): ItemStack?

    /** 获取 MythicItem ID 列表 */
    fun getItemIDList(): List<String>

    /** 获取 MythicItem列表 */
    fun getItemList(): List<Item>

    /** 获取 ActiveMob 实例 */
    fun getMob(entity: Entity): Mob?

    /** 获取所有 Mob ID 列表 */
    fun getMobIDList(): List<String>

    /** 获取 MythicMob 实例 */
    fun getMobType(name: String): MobType?

    /** 获取技能类型 */
    fun getSkillTrigger(name: String): Skill.Trigger

    /**
     * 获取默认技能类型
     */
    fun getDefaultSkillTrigger(): Skill.Trigger

    /** 将字符串转换为技能实例 */
    fun getSkillMechanic(skillLine: String): Skill?

    /** 释放MM技能 */
    fun castSkill(
        caster: Entity,
        skillName: String,
        trigger: Entity? = null,
        origin: Location = caster.location,
        eTargets: Collection<Entity> = emptyList(),
        lTargets: Collection<Location> = emptyList(),
        power: Float = 1f,
    ): Boolean

    companion object {

        @JvmStatic
        lateinit var API: Mythic

        fun isLoaded(): Boolean {
            return ::API.isInitialized
        }
    }
}