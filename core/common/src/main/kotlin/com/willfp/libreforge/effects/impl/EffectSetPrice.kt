package com.willfp.libreforge.effects.impl

import com.willfp.eco.core.config.interfaces.Config
import com.willfp.eco.core.price.Prices
import com.willfp.libreforge.NoCompileData
import com.willfp.libreforge.arguments
import com.willfp.libreforge.effects.Effect
import com.willfp.libreforge.toPlaceholderContext
import com.willfp.libreforge.triggers.TriggerData
import com.willfp.libreforge.triggers.TriggerParameter

object EffectSetPrice : Effect<NoCompileData>("set_price") {
    override val parameters = setOf(TriggerParameter.PLAYER)

    override val arguments = arguments {
        require("value", "You must specify the value of the price to set!")
        require("type", "You must specify the type of currency!")
    }

    override fun onTrigger(config: Config, data: TriggerData, compileData: NoCompileData): Boolean {
        val player = data.player ?: return false

        // Ensure you pass the correct value (as a string) when creating the price object
        val value = config.getString("value").toDoubleOrNull() ?: return false

        Prices.create(
            value.toString(),
            config.getString("type"),
            config.toPlaceholderContext(data)
        ).setTo(player, value)

        return true
    }
}
