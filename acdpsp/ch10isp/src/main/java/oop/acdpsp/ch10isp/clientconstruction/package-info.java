/**
 * The design of interfaces affects the classes that implement the interfaces and the clients
 * that use the interfaces. If clients are to use interfaces, the interfaces must in some way
 * be supplied to the clients.
 *
 * The way you supply the implementations to clients is partly dictated by the number of implementations
 * of the segregated interfaces. If each interface is given its own implementation, each of those
 * implementations needs to be constructed and supplied to the client. Alternatively, if all the interfaces
 * are implemented in a single class, a single instance is sufficient for all of the related dependencies
 * of the client.
 */
package oop.acdpsp.ch10isp.clientconstruction;