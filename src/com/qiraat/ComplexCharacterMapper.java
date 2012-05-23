/* Forked from http://code.google.com/p/malayalam-bible-android/source/browse/trunk/src/com/jeesmon/malayalambible/ComplexCharacterMapper.java */
package com.qiraat;

import com.qiraat.R;

public class ComplexCharacterMapper {
	private static final int DEFAULT_FIX = 0;
	private static final int ALTERNATE_FIX = 1;
	private static final int NO_FIX = 2;
	
	private static int malayalamUnicodeStart = 3328;
	private static int malayalamUnicodeEnd = 3455;

	private static final String[][] mappings = new String[][] {
		//ligature mappings to PUA glyphs
		{ "(.)്വൈ", "\uf3db$1\uf3c4" },
		{ "(.)്വെ", "\uf3d9$1\uf3c4" },
		{ "(.)്വേ", "\uf3da$1\uf3c4" },
		{ "്ര", "\uf301" }, 
		{ "ക്ക", "\uf306" },
		{ "ക്ത", "\uf30b" },
		{ "ക്ഷ", "\uf311" },
		{ "ഗ്ദ", "\uf317" },
		{ "ഗ്ദ്ധ", "\uf319" },
		{ "ഗ്ന", "\uf31c" },
		{ "ഗ്മ", "\uf31f" },
		{ "ങ്ക", "\uf323" },
		{ "ങ്ങ", "\uf327" },
		{ "ച്ച", "\uf329" },
		{ "ജ്ജ", "\uf331" },
		{ "ജ്ഞ", "\uf335" },
		{ "ഞ്ച", "\uf339" },
		{ "ഞ്ഞ", "\uf342" },
		{ "ട്ട", "\uf344" },
		{ "ണ്ട", "\uf34c" },
		{ "ണ്മ", "\uf353" },
		{ "ത്ത", "\uf357" },
		{ "ത്ഥ", "\uf35c" },
		{ "ത്ന", "\uf35f" },
		{ "ത്ഭ", "\uf360" },
		{ "ത്മ", "\uf364" },
		{ "ത്സ", "\uf367" },
		{ "ദ്ദ", "\uf36b" },
		{ "ദ്ധ", "\uf36d" },
		{ "ന്ത", "\uf377" },
		{ "ന്ദ", "\uf37c" },
		{ "ന്ധ", "\uf37F" },
		{ "ന്ന", "\uf382" },
		{ "മ്പ", "\uf387" },
		{ "ന്മ", "\uf38a" },
		{ "ന്റ", "\uf38e" },
		{ "ൻ്റ", "\uf38e" },
		{ "പ്പ", "\uf390" },
		{ "ബ്ബ", "\uf397" },
		{ "മ്മ", "\uf39e" },
		{ "യ്യ", "\uf3a1" },
		{ "ശ്ച", "\uf3ac" },
		{ "ഹ്ന", "\uf3ba" },
		{ "ഹ്മ", "\uf3bd" },
		{ "ള്ള", "\uf3c0" },
		{ "റ്റ", "\uf3c1" },
		{ "്യ", "\uf3c3" },
		{ "്ഥ", "\uf3c5" },
		{ "(.)്സ", "\uf3d0$1" },
		{ "(.)്ഗ", "\uf3c6$1" },
		{ "(.)്ത", "\uf3c7$1" },
		{ "(.)്ധ", "\uf3c8$1" },
		{ "(.)്ന", "\uf3c9$1" },
		{ "(.)്പ", "\uf3ca$1" },
		{ "(.)്മ", "\uf3cb$1" },
		{ "(.)്ശ", "\uf3cc$1" },
		{ "(.)്ല", "\uf3ce$1" },
		{ "(.)്ക", "\uf3cd$1" },
		{ "(.)്ട", "\uf3cf$1" },
		{ "(.)്ണ", "\uf3de$1" },
		{ "ന്റെ", "\uf38e\u0d46" },
		{ "വ്വ", "\uf3a8" },
		{ "(.)്വ", "$1\uf3c4" },
		
		//re-mappings for display
		{ "([\uf3c6-\uf3d0]*.)\uf301", "\uf301$1" },
		{ "([\uf3c6-\uf3d0]*.)\u0d46", "\u0d46$1" },
		{ "([\uf3c6-\uf3d0]*.)\u0d47", "\u0d47$1" },
		{ "([\uf3c6-\uf3d0]*.)\u0d4a", "\u0d46$1\u0d3e" },
		{ "([\uf3c6-\uf3d0]*.)\uf301\u0d4a", "\u0d46\uf301$1\u0d3e" },
		{ "\uf301\u0d46", "\u0d46\uf301" },
		{ "([\uf3c6-\uf3d0]*.)\u0d4b", "\u0d47$1\u0d3e" },
		{ "([\uf3c6-\uf3d0]*.)\uf301\u0d4b", "\u0d47\uf301$1\u0d3e" },
		{ "\uf301\u0d47", "\u0d47\uf301" },
		{ "([\uf3c6-\uf3d0]*.)\u0d4c", "\u0d46$1\u0d57" },
		{ "([\uf3c6-\uf3d0]*.)\u0d48", "\u0d46\u0d46$1" },
		{ "(.)([\u0d46-\u0d47])([\uf3c3-\uf3c5])", "$2$1$3" },
	};
	
	private static final String[][] ligatureMappings = new String[][] {
		//ligature mappings to PUA glyphs
		{ "(.)്വൈ", "\uf3db$1\uf3c4" },
		{ "(.)്വെ", "\uf3d9$1\uf3c4" },
		{ "(.)്വേ", "\uf3da$1\uf3c4" },
		{ "്ര", "\uf301" }, 
		{ "ക്ക", "\uf306" },
		{ "ക്ത", "\uf30b" },
		{ "ക്ഷ", "\uf311" },
		{ "ഗ്ദ", "\uf317" },
		{ "ഗ്ദ്ധ", "\uf319" },
		{ "ഗ്ന", "\uf31c" },
		{ "ഗ്മ", "\uf31f" },
		{ "ങ്ക", "\uf323" },
		{ "ങ്ങ", "\uf327" },
		{ "ച്ച", "\uf329" },
		{ "ജ്ജ", "\uf331" },
		{ "ജ്ഞ", "\uf335" },
		{ "ഞ്ച", "\uf339" },
		{ "ഞ്ഞ", "\uf342" },
		{ "ട്ട", "\uf344" },
		{ "ണ്ട", "\uf34c" },
		{ "ണ്മ", "\uf353" },
		{ "ത്ത", "\uf357" },
		{ "ത്ഥ", "\uf35c" },
		{ "ത്ന", "\uf35f" },
		{ "ത്ഭ", "\uf360" },
		{ "ത്മ", "\uf364" },
		{ "ത്സ", "\uf367" },
		{ "ദ്ദ", "\uf36b" },
		{ "ദ്ധ", "\uf36d" },
		{ "ന്ത", "\uf377" },
		{ "ന്ദ", "\uf37c" },
		{ "ന്ധ", "\uf37F" },
		{ "ന്ന", "\uf382" },
		{ "മ്പ", "\uf387" },
		{ "ന്മ", "\uf38a" },
		{ "ന്റ", "\uf38e" },
		{ "ൻ്റ", "\uf38e" },
		{ "പ്പ", "\uf390" },
		{ "ബ്ബ", "\uf397" },
		{ "മ്മ", "\uf39e" },
		{ "യ്യ", "\uf3a1" },
		{ "ശ്ച", "\uf3ac" },
		{ "ഹ്ന", "\uf3ba" },
		{ "ഹ്മ", "\uf3bd" },
		{ "ള്ള", "\uf3c0" },
		{ "റ്റ", "\uf3c1" },
		{ "്യ", "\uf3c3" },
		{ "്ഥ", "\uf3c5" },
		{ "(.)്സ", "\uf3d0$1" },
		{ "(.)്ഗ", "\uf3c6$1" },
		{ "(.)്ത", "\uf3c7$1" },
		{ "(.)്ധ", "\uf3c8$1" },
		{ "(.)്ന", "\uf3c9$1" },
		{ "(.)്പ", "\uf3ca$1" },
		{ "(.)്മ", "\uf3cb$1" },
		{ "(.)്ശ", "\uf3cc$1" },
		{ "(.)്ല", "\uf3ce$1" },
		{ "(.)്ക", "\uf3cd$1" },
		{ "(.)്ട", "\uf3cf$1" },
		{ "(.)്ണ", "\uf3de$1" },
		{ "ന്റെ", "\uf38e\u0d46" },
		{ "വ്വ", "\uf3a8" },
		{ "(.)്വ", "$1\uf3c4" },

		{ "([\uf301-\uf3d0])\u0d02", "$1\uf3d1" },
		{ "([\uf301-\uf3d0])\u0d03", "$1\uf3d2" },
		{ "([\uf301-\uf3d0])\u0d3e", "$1\uf3d3" },
		{ "([\uf301-\uf3d0])\u0d3f", "$1\uf3d4" },
		{ "([\uf301-\uf3d0])\u0d40", "$1\uf3d5" },
		{ "([\uf301-\uf3d0])\u0d41", "$1\uf3d6" },		
		{ "([\uf301-\uf3d0])\u0d42", "$1\uf3d7" },
		{ "([\uf301-\uf3d0])\u0d43", "$1\uf3d8" },
		{ "([\uf301-\uf3d0])\u0d4d", "$1\uf3dc" },
		{ "([\uf301-\uf3d0])\u0d57", "$1\uf3dd" },
		{ "([\uf301-\uf3d0])\u0d46", "\uf3d9$1" },
		{ "([\uf301-\uf3d0])\u0d47", "\uf3da$1" },
		{ "([\uf301-\uf3d0])\u0d48", "\uf3db$1" },
		{ "([\uf301-\uf3d0])\u0d4a", "\uf3d9$1\uf3d3" },
		{ "([\uf301-\uf3d0])\u0d4b", "\uf3da$1\uf3d3" },
				
		{ "(.)([\uf3d9])([\uf3c3-\uf3c5])", "\uf3d9$1$3" },
		{ "(.)([\uf3da])([\uf3c3-\uf3c5])", "\uf3da$1$3" },
		{ "(.)([\uf3db])([\uf3c3-\uf3c5])", "\uf3db$1$3" },
		{ "([\uf3d3-\uf3d8])\u0d02", "$1\uf3d1" },
		{ "([\uf3d3-\uf3d8])\u0d03", "$1\uf3d2" },
				
		{ "(.)\uf301", "\uf301$1" },
		
		{ "(.)\u0d46\u0d3e", "\uf3d9$1\uf3d3" },
		{ "(.)\u0d47\u0d3e", "\uf3da$1\uf3d3" },
		
		{ "([\uf301-\uf3d0])\u0d3e", "$1\uf3d3" },
		{ "([\uf301-\uf3d0])\u0d3f", "$1\uf3d4" },
		{ "([\uf301-\uf3d2])\u0d40", "$1\uf3d5" },
		{ "([\uf301-\uf3d2])\u0d41", "$1\uf3d6" },
		{ "([\uf301-\uf3d2])\u0d42", "$1\uf3d7" },
		{ "([\uf301-\uf3d2])\u0d43", "$1\uf3d8" },
		
		{ "([\uf3c6-\uf3d0])\uf301(.)", "\uf301$1$2" },
		{ "([\uf3c6-\uf3d0])(.)\u0d46", "\uf3d9$1$2" },
		{ "([\uf3c6-\uf3d0])(.)\u0d47", "\uf3da$1$2" },
		{ "([\uf3c6-\uf3d0])(.)\u0d48", "\uf3db$1$2" },
	};

	public static String fix(String text, int fixType) {
		if(fixType == NO_FIX) {
			return text;
		}
		
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) >= malayalamUnicodeStart
					&& text.charAt(i) <= malayalamUnicodeEnd) {
				
				if(fixType == ALTERNATE_FIX) {
					for (int j = 0; j < ligatureMappings.length; j++) {
						text = text.replaceAll(ligatureMappings[j][0], ligatureMappings[j][1]);
					}
				}
				else if(fixType == DEFAULT_FIX) {
					for (int j = 0; j < mappings.length; j++) {
						text = text.replaceAll(mappings[j][0], mappings[j][1]);
					}
				}
				break;
			}
		}

		return text;
	}
}
