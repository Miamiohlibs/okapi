/*
 * Copyright (C) 2016 Index Data
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.folio.okapi.util;

import java.util.LinkedList;
import java.util.List;

public class SplitProcessArgs {

  public static List<String> split(String cmd) {
    boolean q = false;
    List<String> l = new LinkedList<>();
    int j = 0;
    int i = 0;
    while (i < cmd.length()) {
      if (cmd.charAt(i) == '\"') {
        if (i > j) {
          l.add(cmd.substring(j, i));
        }
        j = i + 1;
        q = !q;
      } else if (!q && cmd.charAt(i) == ' ') {
        if (i > j) {
          l.add(cmd.substring(j, i));
        }
        j = i + 1;
      }
      i++;
    }
    if (i > j) {
      l.add(cmd.substring(j, i));
    }
    return l;
  }
}