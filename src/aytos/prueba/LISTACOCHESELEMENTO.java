/**
 * LISTACOCHESELEMENTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package aytos.prueba;

public class LISTACOCHESELEMENTO  implements java.io.Serializable {
    private aytos.prueba.COCHE coche;

    public LISTACOCHESELEMENTO() {
    }

    public LISTACOCHESELEMENTO(
           aytos.prueba.COCHE coche) {
           this.coche = coche;
    }


    /**
     * Gets the coche value for this LISTACOCHESELEMENTO.
     * 
     * @return coche
     */
    public aytos.prueba.COCHE getCoche() {
        return coche;
    }


    /**
     * Sets the coche value for this LISTACOCHESELEMENTO.
     * 
     * @param coche
     */
    public void setCoche(aytos.prueba.COCHE coche) {
        this.coche = coche;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LISTACOCHESELEMENTO)) return false;
        LISTACOCHESELEMENTO other = (LISTACOCHESELEMENTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.coche==null && other.getCoche()==null) || 
             (this.coche!=null &&
              this.coche.equals(other.getCoche())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCoche() != null) {
            _hashCode += getCoche().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LISTACOCHESELEMENTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://prueba.aytos", ">LISTACOCHES>ELEMENTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coche");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coche"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://prueba.aytos", "COCHE"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
