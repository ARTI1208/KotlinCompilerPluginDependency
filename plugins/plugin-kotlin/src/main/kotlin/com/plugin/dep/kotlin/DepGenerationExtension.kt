package com.plugin.dep.kotlin

import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment

class DepGenerationExtension(
    private val messageCollector: MessageCollector,
) : IrGenerationExtension {
    override fun generate(moduleFragment: IrModuleFragment, pluginContext: IrPluginContext) {

//        messageCollector.report(CompilerMessageSeverity.INFO, "Argument 'string' = $string")
//        messageCollector.report(CompilerMessageSeverity.INFO, "Argument 'file' = $file")

//        val addSourceToBlock = pluginContext
//            .referenceFunctions(
//                CallableId(
//                packageName = FqName("io.koalaql.kapshot"),
//                callableName = Name.identifier("addSourceToBlock")
//            )
//            )
//            .first()

//        throw IllegalStateException("fhdjfdhgf")

//        println(moduleFragment.dump())

//        throw IllegalStateException((javaClass.classLoader as URLClassLoader).urLs.joinToString())

        val res = moduleFragment.transform(
            DepTransformer(
                messageCollector,
                pluginContext,
//                projectDir,
//                addSourceToBlock
            ),
            null
        )

//        println(res.dump())
    }
}