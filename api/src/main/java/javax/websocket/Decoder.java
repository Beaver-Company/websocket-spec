/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2012 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package javax.websocket;

import java.util.Iterator;
import java.io.*;
import java.nio.*;

/**
 * The Decoder interface holds member interfaces that define how a developer can provide
 * the web socket container a way web socket messages into developer defined custom objects.
 * @author dannycoward
 * @since DRAFT 002
 */
public interface Decoder {

     /** This interface defines how a custom object (of type T) is decoded from a web socket message in
     * the form of a byte buffer.
     */
     interface Binary<T> extends Decoder {

        /** 
         * Decode the given bytes into an object of type T.
         @param bytes the bytes to be decoded.
         * @return the decoded object
         */
         T decode(ByteBuffer bytes) throws DecodeException;
        /** Answer whether the given bytes can be decoded into an object of type T.
         * @bytes the bytes to be decoded.
         * @return whether or not the bytes can be decoded by this decoder.
         */
         boolean willDecode(ByteBuffer bytes);
    }

    /** This interface defines how a custom object is decoded from a web socket message in
     * the form of a binary stream.
     */
     interface BinaryStream<T> extends Decoder {

        /**
         * Decode the given bytes read from the input stream into an object of type T.
         * @return the decoded object
         * @param is the input stream carrying the bytes
         */
         T decode(InputStream is) throws DecodeException, IOException;
    }

     /** 
      * This interface defines how a custom object is decoded from a web socket message in
     * the form of a string. 
     */
     interface Text<T> extends Decoder {
        /** Decode the given String into an object of type T.
         * @param the string to be decoded.
         * @return the decoded message as an object of type T
         */
         T decode(String s) throws DecodeException;
        /** Answer whether the given String can be decoded into an object of type T.
         *
         * @param s the string being tested for decodability
         * @return whether this decoder can decoded the supplied string.
         */
         boolean willDecode(String s);
    }
     /** This interface defines how a custom object of type T is decoded from a web socket message in
     * the form of a character stream. */
     interface TextStream<T> extends Decoder {
        /** Reads the websocket message from the implementation provided
         * Reader and decodes it into an instance of the supplied object type.
         * @param reader the reader from which to read the web socket message.
         * @return the instance of the object that is the decoded web socket message.
         */
         T decode(Reader reader) throws DecodeException, IOException;
    }


}