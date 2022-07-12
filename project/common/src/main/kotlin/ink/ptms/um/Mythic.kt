package ink.ptms.um

import org.bukkit.entity.Entity
import org.bukkit.inventory.ItemStack

interface Mythic {

    /**
     * 是否 4.X 版本
     */
    val isLegacy: Boolean

    /**
     * 获取 MythicItem 实例
     */
    fun getItem(name: String): Item?

    /**
     * 获取 MythicItem 实例并构建到 ItemStack
     */
    fun getItemStack(name: String): ItemStack?

    /**
     * 获取物品在MM中的ID
     */
    fun whatMythicItem(itemStack: ItemStack): String?

    /**
     * 获取 ActiveMob 实例
     */
    fun getMob(entity: Entity): Mob?

    /**
     * 获取 MythicMob 实例
     */
    fun getMobType(name: String): MobType?

    /**
     * 获取技能类型
     */
    fun getSkillTrigger(name: String): Skill.Trigger

    /**
     * 将字符串转换为技能实例
     */
    fun getSkillMechanic(skillLine: String): Skill?

    companion object {

        @JvmStatic
        lateinit var API: Mythic
    }
}