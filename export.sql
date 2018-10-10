--------------------------------------------------------
-- Archivo creado  - martes-octubre-09-2018   
--------------------------------------------------------
DROP TABLE "NIGHTRIDERS"."ALMACENAMIENTOS" cascade constraints;
DROP TABLE "NIGHTRIDERS"."CIUDADES" cascade constraints;
DROP TABLE "NIGHTRIDERS"."FAMILIAS" cascade constraints;
DROP TABLE "NIGHTRIDERS"."LOCALES" cascade constraints;
DROP TABLE "NIGHTRIDERS"."MOVIMIENTOS" cascade constraints;
DROP TABLE "NIGHTRIDERS"."PEDIDOS" cascade constraints;
DROP TABLE "NIGHTRIDERS"."PERFILES" cascade constraints;
DROP TABLE "NIGHTRIDERS"."PRODUCTOS" cascade constraints;
DROP TABLE "NIGHTRIDERS"."RECEPCION" cascade constraints;
DROP TABLE "NIGHTRIDERS"."RENGLONESPEDIDOS" cascade constraints;
DROP TABLE "NIGHTRIDERS"."USUARIOS" cascade constraints;
--------------------------------------------------------
--  DDL for Table ALMACENAMIENTOS
--------------------------------------------------------

  CREATE TABLE "NIGHTRIDERS"."ALMACENAMIENTOS" 
   (	"ALMA_ID" NUMBER(*,0), 
	"LOC_ID" NUMBER(*,0), 
	"ALMA_VOLUMEN" NUMBER(*,0), 
	"ALMA_DESCRIPCION" VARCHAR2(100 BYTE), 
	"ALMA_COSTOOP" BINARY_DOUBLE, 
	"ALMA_CAPESTIBA" NUMBER(*,0), 
	"ALMA_CAPPESO" NUMBER(*,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CIUDADES
--------------------------------------------------------

  CREATE TABLE "NIGHTRIDERS"."CIUDADES" 
   (	"CIU_NOMBRE" VARCHAR2(50 BYTE), 
	"CIU_ID" NUMBER(*,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table FAMILIAS
--------------------------------------------------------

  CREATE TABLE "NIGHTRIDERS"."FAMILIAS" 
   (	"FAMI_CODI" NUMBER(*,0), 
	"FAMI_INCOMPAT" VARCHAR2(2 BYTE), 
	"FAMI_NOMBRE" VARCHAR2(50 BYTE), 
	"FAMI_DESCRIP" VARCHAR2(100 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table LOCALES
--------------------------------------------------------

  CREATE TABLE "NIGHTRIDERS"."LOCALES" 
   (	"LOC_ID" NUMBER(*,0), 
	"CIU_ID" NUMBER(*,0), 
	"LOC_DESCRIP" VARCHAR2(100 BYTE), 
	"LOC_DIRECCION" VARCHAR2(100 BYTE), 
	"LOC_TIPO" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MOVIMIENTOS
--------------------------------------------------------

  CREATE TABLE "NIGHTRIDERS"."MOVIMIENTOS" 
   (	"PROD_ID" NUMBER(*,0), 
	"ALMA_ID" NUMBER(*,0), 
	"MOV_FECHA" DATE, 
	"MOV_CANTIDAD" NUMBER(*,0), 
	"MOV_DESCRIPCION" VARCHAR2(100 BYTE), 
	"MOV_PROD" VARCHAR2(50 BYTE), 
	"MOV_TIPO" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PEDIDOS
--------------------------------------------------------

  CREATE TABLE "NIGHTRIDERS"."PEDIDOS" 
   (	"PED_ID" NUMBER(*,0), 
	"USU_CODIGO" NUMBER(*,0), 
	"PED_ESTADO" VARCHAR2(2 BYTE), 
	"PED_FEC_ESTIM_ENT" DATE, 
	"PED_FECHA" DATE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PERFILES
--------------------------------------------------------

  CREATE TABLE "NIGHTRIDERS"."PERFILES" 
   (	"PERF_CODIGO" NUMBER(*,0), 
	"PERF_NOMBRE" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PRODUCTOS
--------------------------------------------------------

  CREATE TABLE "NIGHTRIDERS"."PRODUCTOS" 
   (	"PROD_ID" NUMBER(*,0), 
	"USU_CODIGO" NUMBER(*,0), 
	"FAMI_CODI" NUMBER(*,0), 
	"PROD_VOL" NUMBER(*,0), 
	"PROD_PESO" NUMBER(*,0), 
	"PROD_LOTE" NUMBER(*,0), 
	"PROD_FVEN" DATE, 
	"PROD_FELAB" DATE, 
	"PROD_NOMBRE" VARCHAR2(50 BYTE), 
	"PROD_ESTIBA" VARCHAR2(2 BYTE), 
	"PROD_SEGMETAC" VARCHAR2(2 BYTE), 
	"PROD_STKMIN" NUMBER(*,0), 
	"PROD_STKTOTAL" NUMBER(*,0), 
	"PROD_PRECIO" BINARY_DOUBLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table RECEPCION
--------------------------------------------------------

  CREATE TABLE "NIGHTRIDERS"."RECEPCION" 
   (	"REC_CODIGO" NUMBER(*,0), 
	"USU_CODIGO" NUMBER(*,0), 
	"PED_ID" NUMBER(*,0), 
	"REC_FECHA" DATE, 
	"REC_COMENTARIO" VARCHAR2(100 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table RENGLONESPEDIDOS
--------------------------------------------------------

  CREATE TABLE "NIGHTRIDERS"."RENGLONESPEDIDOS" 
   (	"PROD_ID" NUMBER(*,0), 
	"PED_ID" NUMBER(*,0), 
	"RENPED_NRO" NUMBER(*,0), 
	"RENPED_CANT" NUMBER(*,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USUARIOS
--------------------------------------------------------

  CREATE TABLE "NIGHTRIDERS"."USUARIOS" 
   (	"USU_CODIGO" NUMBER(*,0), 
	"PERF_CODIGO" NUMBER(*,0), 
	"USU_NOMBRE" VARCHAR2(50 BYTE), 
	"USU_APELLIDO" VARCHAR2(50 BYTE), 
	"USU_NOMACCESO" VARCHAR2(50 BYTE), 
	"USU_CONTRASENA" VARCHAR2(50 BYTE), 
	"USU_CORREO" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into NIGHTRIDERS.ALMACENAMIENTOS
SET DEFINE OFF;
REM INSERTING into NIGHTRIDERS.CIUDADES
SET DEFINE OFF;
REM INSERTING into NIGHTRIDERS.FAMILIAS
SET DEFINE OFF;
REM INSERTING into NIGHTRIDERS.LOCALES
SET DEFINE OFF;
REM INSERTING into NIGHTRIDERS.MOVIMIENTOS
SET DEFINE OFF;
REM INSERTING into NIGHTRIDERS.PEDIDOS
SET DEFINE OFF;
REM INSERTING into NIGHTRIDERS.PERFILES
SET DEFINE OFF;
REM INSERTING into NIGHTRIDERS.PRODUCTOS
SET DEFINE OFF;
REM INSERTING into NIGHTRIDERS.RECEPCION
SET DEFINE OFF;
REM INSERTING into NIGHTRIDERS.RENGLONESPEDIDOS
SET DEFINE OFF;
REM INSERTING into NIGHTRIDERS.USUARIOS
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index PK_ALMA_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "NIGHTRIDERS"."PK_ALMA_ID" ON "NIGHTRIDERS"."ALMACENAMIENTOS" ("ALMA_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_CIU_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "NIGHTRIDERS"."PK_CIU_ID" ON "NIGHTRIDERS"."CIUDADES" ("CIU_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_FAMI_CODI
--------------------------------------------------------

  CREATE UNIQUE INDEX "NIGHTRIDERS"."PK_FAMI_CODI" ON "NIGHTRIDERS"."FAMILIAS" ("FAMI_CODI") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_LOC_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "NIGHTRIDERS"."PK_LOC_ID" ON "NIGHTRIDERS"."LOCALES" ("LOC_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_PED_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "NIGHTRIDERS"."PK_PED_ID" ON "NIGHTRIDERS"."PEDIDOS" ("PED_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_PERF_CODIGO
--------------------------------------------------------

  CREATE UNIQUE INDEX "NIGHTRIDERS"."PK_PERF_CODIGO" ON "NIGHTRIDERS"."PERFILES" ("PERF_CODIGO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_PROD_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "NIGHTRIDERS"."PK_PROD_ID" ON "NIGHTRIDERS"."PRODUCTOS" ("PROD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_REC_CODIGO
--------------------------------------------------------

  CREATE UNIQUE INDEX "NIGHTRIDERS"."PK_REC_CODIGO" ON "NIGHTRIDERS"."RECEPCION" ("REC_CODIGO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_USU_CODIGO
--------------------------------------------------------

  CREATE UNIQUE INDEX "NIGHTRIDERS"."PK_USU_CODIGO" ON "NIGHTRIDERS"."USUARIOS" ("USU_CODIGO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_FAMI_NOMBRE
--------------------------------------------------------

  CREATE UNIQUE INDEX "NIGHTRIDERS"."UK_FAMI_NOMBRE" ON "NIGHTRIDERS"."FAMILIAS" ("FAMI_NOMBRE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_NOMACCESO
--------------------------------------------------------

  CREATE UNIQUE INDEX "NIGHTRIDERS"."UK_NOMACCESO" ON "NIGHTRIDERS"."USUARIOS" ("USU_NOMACCESO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_PERF_NOMBRE
--------------------------------------------------------

  CREATE UNIQUE INDEX "NIGHTRIDERS"."UK_PERF_NOMBRE" ON "NIGHTRIDERS"."PERFILES" ("PERF_NOMBRE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_PROD_NOMBRE
--------------------------------------------------------

  CREATE UNIQUE INDEX "NIGHTRIDERS"."UK_PROD_NOMBRE" ON "NIGHTRIDERS"."PRODUCTOS" ("PROD_NOMBRE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_USU_CORREO
--------------------------------------------------------

  CREATE UNIQUE INDEX "NIGHTRIDERS"."UK_USU_CORREO" ON "NIGHTRIDERS"."USUARIOS" ("USU_CORREO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table ALMACENAMIENTOS
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."ALMACENAMIENTOS" ADD CONSTRAINT "PK_ALMA_ID" PRIMARY KEY ("ALMA_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "NIGHTRIDERS"."ALMACENAMIENTOS" MODIFY ("ALMA_ID" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."ALMACENAMIENTOS" MODIFY ("LOC_ID" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."ALMACENAMIENTOS" MODIFY ("ALMA_VOLUMEN" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."ALMACENAMIENTOS" MODIFY ("ALMA_DESCRIPCION" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."ALMACENAMIENTOS" MODIFY ("ALMA_COSTOOP" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."ALMACENAMIENTOS" MODIFY ("ALMA_CAPESTIBA" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."ALMACENAMIENTOS" MODIFY ("ALMA_CAPPESO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CIUDADES
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."CIUDADES" ADD CONSTRAINT "PK_CIU_ID" PRIMARY KEY ("CIU_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "NIGHTRIDERS"."CIUDADES" MODIFY ("CIU_NOMBRE" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."CIUDADES" MODIFY ("CIU_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table FAMILIAS
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."FAMILIAS" ADD CONSTRAINT "PK_FAMI_CODI" PRIMARY KEY ("FAMI_CODI")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "NIGHTRIDERS"."FAMILIAS" MODIFY ("FAMI_CODI" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."FAMILIAS" MODIFY ("FAMI_INCOMPAT" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."FAMILIAS" MODIFY ("FAMI_NOMBRE" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."FAMILIAS" ADD CONSTRAINT "UK_FAMI_NOMBRE" UNIQUE ("FAMI_NOMBRE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table LOCALES
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."LOCALES" ADD CONSTRAINT "PK_LOC_ID" PRIMARY KEY ("LOC_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "NIGHTRIDERS"."LOCALES" MODIFY ("LOC_ID" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."LOCALES" MODIFY ("CIU_ID" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."LOCALES" MODIFY ("LOC_DESCRIP" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."LOCALES" MODIFY ("LOC_DIRECCION" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."LOCALES" MODIFY ("LOC_TIPO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MOVIMIENTOS
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."MOVIMIENTOS" MODIFY ("PROD_ID" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."MOVIMIENTOS" MODIFY ("ALMA_ID" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."MOVIMIENTOS" MODIFY ("MOV_FECHA" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."MOVIMIENTOS" MODIFY ("MOV_CANTIDAD" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."MOVIMIENTOS" MODIFY ("MOV_PROD" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."MOVIMIENTOS" MODIFY ("MOV_TIPO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PEDIDOS
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."PEDIDOS" ADD CONSTRAINT "PK_PED_ID" PRIMARY KEY ("PED_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "NIGHTRIDERS"."PEDIDOS" MODIFY ("PED_ID" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PEDIDOS" MODIFY ("USU_CODIGO" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PEDIDOS" MODIFY ("PED_ESTADO" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PEDIDOS" MODIFY ("PED_FEC_ESTIM_ENT" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PEDIDOS" MODIFY ("PED_FECHA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PERFILES
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."PERFILES" ADD CONSTRAINT "PK_PERF_CODIGO" PRIMARY KEY ("PERF_CODIGO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "NIGHTRIDERS"."PERFILES" MODIFY ("PERF_CODIGO" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PERFILES" MODIFY ("PERF_NOMBRE" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PERFILES" ADD CONSTRAINT "UK_PERF_NOMBRE" UNIQUE ("PERF_NOMBRE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PRODUCTOS
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."PRODUCTOS" ADD CONSTRAINT "PK_PROD_ID" PRIMARY KEY ("PROD_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "NIGHTRIDERS"."PRODUCTOS" MODIFY ("PROD_ID" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PRODUCTOS" MODIFY ("USU_CODIGO" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PRODUCTOS" MODIFY ("FAMI_CODI" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PRODUCTOS" MODIFY ("PROD_VOL" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PRODUCTOS" MODIFY ("PROD_PESO" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PRODUCTOS" MODIFY ("PROD_LOTE" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PRODUCTOS" MODIFY ("PROD_FVEN" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PRODUCTOS" MODIFY ("PROD_NOMBRE" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PRODUCTOS" MODIFY ("PROD_ESTIBA" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PRODUCTOS" MODIFY ("PROD_SEGMETAC" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PRODUCTOS" MODIFY ("PROD_STKMIN" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PRODUCTOS" MODIFY ("PROD_STKTOTAL" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PRODUCTOS" MODIFY ("PROD_PRECIO" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."PRODUCTOS" ADD CONSTRAINT "UK_PROD_NOMBRE" UNIQUE ("PROD_NOMBRE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table RECEPCION
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."RECEPCION" ADD CONSTRAINT "PK_REC_CODIGO" PRIMARY KEY ("REC_CODIGO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "NIGHTRIDERS"."RECEPCION" MODIFY ("REC_CODIGO" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."RECEPCION" MODIFY ("USU_CODIGO" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."RECEPCION" MODIFY ("PED_ID" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."RECEPCION" MODIFY ("REC_FECHA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RENGLONESPEDIDOS
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."RENGLONESPEDIDOS" MODIFY ("PROD_ID" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."RENGLONESPEDIDOS" MODIFY ("PED_ID" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."RENGLONESPEDIDOS" MODIFY ("RENPED_NRO" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."RENGLONESPEDIDOS" MODIFY ("RENPED_CANT" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USUARIOS
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."USUARIOS" ADD CONSTRAINT "PK_USU_CODIGO" PRIMARY KEY ("USU_CODIGO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "NIGHTRIDERS"."USUARIOS" MODIFY ("USU_CODIGO" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."USUARIOS" MODIFY ("PERF_CODIGO" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."USUARIOS" MODIFY ("USU_NOMBRE" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."USUARIOS" MODIFY ("USU_APELLIDO" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."USUARIOS" MODIFY ("USU_NOMACCESO" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."USUARIOS" MODIFY ("USU_CONTRASENA" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."USUARIOS" MODIFY ("USU_CORREO" NOT NULL ENABLE);
 
  ALTER TABLE "NIGHTRIDERS"."USUARIOS" ADD CONSTRAINT "UK_NOMACCESO" UNIQUE ("USU_NOMACCESO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "NIGHTRIDERS"."USUARIOS" ADD CONSTRAINT "UK_USU_CORREO" UNIQUE ("USU_CORREO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ALMACENAMIENTOS
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."ALMACENAMIENTOS" ADD CONSTRAINT "FK_ALMA_LOC" FOREIGN KEY ("LOC_ID")
	  REFERENCES "NIGHTRIDERS"."LOCALES" ("LOC_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table LOCALES
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."LOCALES" ADD CONSTRAINT "FK_LOC_CIU" FOREIGN KEY ("CIU_ID")
	  REFERENCES "NIGHTRIDERS"."CIUDADES" ("CIU_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table MOVIMIENTOS
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."MOVIMIENTOS" ADD CONSTRAINT "FK_MOV_ALMA" FOREIGN KEY ("ALMA_ID")
	  REFERENCES "NIGHTRIDERS"."ALMACENAMIENTOS" ("ALMA_ID") ENABLE;
 
  ALTER TABLE "NIGHTRIDERS"."MOVIMIENTOS" ADD CONSTRAINT "FK_MOV_PROD" FOREIGN KEY ("PROD_ID")
	  REFERENCES "NIGHTRIDERS"."PRODUCTOS" ("PROD_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PRODUCTOS
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."PRODUCTOS" ADD CONSTRAINT "FK_PROD_FAMI" FOREIGN KEY ("FAMI_CODI")
	  REFERENCES "NIGHTRIDERS"."FAMILIAS" ("FAMI_CODI") ENABLE;
 
  ALTER TABLE "NIGHTRIDERS"."PRODUCTOS" ADD CONSTRAINT "FK_PROD_USU" FOREIGN KEY ("USU_CODIGO")
	  REFERENCES "NIGHTRIDERS"."USUARIOS" ("USU_CODIGO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RECEPCION
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."RECEPCION" ADD CONSTRAINT "FK_REC_PED" FOREIGN KEY ("PED_ID")
	  REFERENCES "NIGHTRIDERS"."PEDIDOS" ("PED_ID") ENABLE;
 
  ALTER TABLE "NIGHTRIDERS"."RECEPCION" ADD CONSTRAINT "FK_REC_USU" FOREIGN KEY ("USU_CODIGO")
	  REFERENCES "NIGHTRIDERS"."USUARIOS" ("USU_CODIGO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RENGLONESPEDIDOS
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."RENGLONESPEDIDOS" ADD CONSTRAINT "FK_RENPED_PED" FOREIGN KEY ("PED_ID")
	  REFERENCES "NIGHTRIDERS"."PEDIDOS" ("PED_ID") ENABLE;
 
  ALTER TABLE "NIGHTRIDERS"."RENGLONESPEDIDOS" ADD CONSTRAINT "FK_RENPED_PROD" FOREIGN KEY ("PROD_ID")
	  REFERENCES "NIGHTRIDERS"."PRODUCTOS" ("PROD_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USUARIOS
--------------------------------------------------------

  ALTER TABLE "NIGHTRIDERS"."USUARIOS" ADD CONSTRAINT "FK_PERF_USU" FOREIGN KEY ("USU_CODIGO")
	  REFERENCES "NIGHTRIDERS"."PERFILES" ("PERF_CODIGO") ENABLE;
