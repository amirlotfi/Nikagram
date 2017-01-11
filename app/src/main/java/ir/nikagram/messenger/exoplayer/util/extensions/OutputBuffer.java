/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ir.nikagram.messenger.exoplayer.util.extensions;

/**
 * Output buffer decoded by a {@link Decoder}.
 */
public abstract class OutputBuffer extends Buffer {

  /**
   * The presentation timestamp for the buffer, in microseconds.
   */
  public long timestampUs;

  /**
   * Releases the output buffer for reuse. Must be called when the buffer is no longer needed.
   */
  public abstract void release();

}