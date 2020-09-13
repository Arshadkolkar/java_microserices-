/**
 * 
 */
package com.sca.dao.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.hibernate.transform.AliasedTupleSubsetResultTransformer;

/**
 * 
 * @author subhash
 *
 */
public class AliasToEntityOrderedMapResultTransformer extends AliasedTupleSubsetResultTransformer {

	private static final long serialVersionUID = 1L;

	public static final AliasToEntityOrderedMapResultTransformer INSTANCE = new AliasToEntityOrderedMapResultTransformer();

	/**
	 * Disallow instantiation of AliasToEntityOrderedMapResultTransformer.
	 */
	private AliasToEntityOrderedMapResultTransformer() {
	}

	/**
	 * 
	 */
	@Override
	public Object transformTuple(Object[] tuple, String[] aliases) {
		Map<String, Object> result = new LinkedHashMap<String, Object>(tuple.length);
		for (int i = 0; i < tuple.length; i++) {
			if (aliases[i] != null) {
				result.put(CaseFormatHelper.snakeToCamelCase(aliases[i]), tuple[i]);
			}
		}
		return result;
	}

	/**
	 * 
	 */
	@Override
	public boolean isTransformedValueATupleElement(String[] aliases, int tupleLength) {
		return false;
	}

	/**
	 * Serialization hook for ensuring singleton uniqueing.
	 *
	 * @return The singleton instance : {@link #INSTANCE}
	 */
	private Object readResolve() {
		return INSTANCE;
	}
}
