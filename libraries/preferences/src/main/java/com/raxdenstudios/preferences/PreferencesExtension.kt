package com.raxdenstudios.preferences

import android.content.SharedPreferences

public fun SharedPreferences.edit(
  commit: Boolean = false,
  action: SharedPreferences.Editor.() -> Unit
) {
  val editor = edit()
  action(editor)
  if (commit) {
    editor.commit()
  } else {
    editor.apply()
  }
}

public fun AdvancedPreferences.edit(
  commit: Boolean = false,
  action: AdvancedPreferences.Editor.() -> Unit
) {
  val editor = edit()
  action(editor)
  if (commit) {
    editor.commit()
  } else {
    editor.apply()
  }
}
