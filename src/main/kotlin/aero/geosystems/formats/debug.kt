package aero.geosystems.formats

/*
 * Created by aimozg on 13.02.2019.
 * Confidential unless published on GitHub
 */
fun inspectStruct(s:StructBinding):String = buildString {
	val def = s.definition()
	append(s.javaClass.simpleName)
	append("/")
	append(def.javaClass.simpleName)
	append("{")

	for (member in def.members) {
		append("\n\t")
		append(member.pos.bitSize(s)/8)
		append(":")
		append(member.pos.start(s)/8)
		append("..")
		append(member.pos.end(s)/8)
		append(" ")
		append(member.javaClass.simpleName)
		when (member) {
			is StructDef<*>.StructMember<*> -> {
				append(" ")
				val value = member.getValue(s)
				append(inspectStruct(value).replace("\n","\n\t"))
			}
			is StructDef<*>.StructArrayMember<*> -> {
				append(" [")
				val value = member.getValue(s)
				for (s2 in value) {
					append(("\n"+inspectStruct(s2)).replace("\n","\n\t"))
				}
				append("]")
			}
			is StructDef<*>.NumberMember<*> -> {
				append(" = ")
				try {
					append(member.getValue(s))
					append(" (")
					append(member.getUnsigned(s))
					append(")")
				} catch (e:Throwable) {
					append(e)
				}
			}
		}
	}

	append("\n}")
}