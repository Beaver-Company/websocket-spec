/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2012-2013 Oracle and/or its affiliates. All rights reserved.
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

/**
 * The result of asynchronously sending a web socket message. A SendResult is either
 * ok indicating there was no problem, or is not OK in which case there was a problem
 * and it carries an exception to indicate what the problem was.
 *
 * @author dannycoward
 * @since DRAFT 002
 */
public class SendResult {

    private Throwable exception;
    private boolean isOK = true;

    /**
     * Construct a SendResult carrying an exception.
     *
     * @param exception the exception causing a send failure.
     */
    public SendResult(Throwable exception) {
        this.exception = exception;
        this.isOK = false;
    }

    /**
     * Construct a SendResult signifying a successful send carrying an no exception.
     */
    public SendResult() {
    }

    /**
     * The problem sending the message.
     *
     * @return the problem.
     */
    public Throwable getException() {
        return exception;
    }

    /**
     * Determines if this result is ok or not.
     *
     * @return whether the send was successful or not.
     */
    public boolean isOK() {
        return this.isOK;
    }
}